package cn.cxnxs.minio.config;

import cn.cxnxs.minio.entity.ObjectItem;
import com.alibaba.fastjson.JSONObject;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Component
public class MinioTemplate {
    @Autowired
    private MinioProperties minioProperties;

    @Autowired
    private MinioClient minioClient;

    @Value("${spring.application.name}")
    private String appName;

    /**
     * description: 判断bucket是否存在，不存在则创建
     *
     * @return: void
     */
    public boolean existBucket(String name) {
        boolean exists;
        try {
            exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
                exists = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            exists = false;
        }
        return exists;
    }

    /**
     * 创建存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */
    public Boolean makeBucket(String bucketName) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除存储bucket
     *
     * @param bucketName 存储bucket名称
     * @return Boolean
     */
    public Boolean removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String upload(MultipartFile file) {
        return this.upload(file,null,null);
    }
    /**
     * description: 上传文件
     *
     * @param file
     * @return: java.lang.String
     */
    public String upload(MultipartFile file, String bucketNameStr, String path) {
        String fileName = file.getOriginalFilename();
        String[] split = fileName.split("\\.");
        if (split.length > 1) {
            fileName = split[0] + "_" + System.currentTimeMillis() + "." + split[1];
        } else {
            fileName = fileName + System.currentTimeMillis();
        }
        if (!StringUtils.isEmpty(path)) {
            fileName = path + "/" +fileName;
        }
        fileName = appName + "/" +fileName;
        InputStream in = null;
        try {
            if (StringUtils.isEmpty(bucketNameStr)) {
                bucketNameStr = minioProperties.getBucketName();
            }
            in = file.getInputStream();
            ObjectWriteResponse objectWriteResponse = minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketNameStr)
                    .object(fileName)
                    .stream(in, in.available(), -1)
                    .contentType(file.getContentType())
                    .build()
            );
            log.info("对象存储请求结果：{}", objectWriteResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bucketNameStr + "/" + fileName;
    }

    /**
     * description: 下载文件
     *
     * @param fileName
     * @return: org.springframework.http.ResponseEntity<byte [ ]>
     */
    public ResponseEntity<byte[]> download(String bucketNameStr, String fileName) {
        ResponseEntity<byte[]> responseEntity = null;
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            String bucketName;
            if (StringUtils.isEmpty(bucketNameStr)) {
                bucketNameStr = minioProperties.getBucketName();
            }
            bucketName = bucketNameStr;

            in = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
            out = new ByteArrayOutputStream();
            IOUtils.copy(in, out);
            //封装返回值
            byte[] bytes = out.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            try {
                headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            headers.setContentLength(bytes.length);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setAccessControlExposeHeaders(Collections.singletonList("*"));
            responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseEntity;
    }
    /**
     * 查看文件对象
     *
     * @param bucketName 存储bucket名称
     * @return 存储bucket内文件对象信息
     */
    public List<ObjectItem> listObjects(String bucketName) {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<ObjectItem> objectItems = new ArrayList<>();
        try {
            for (Result<Item> result : results) {
                Item item = result.get();
                ObjectItem objectItem = new ObjectItem();
                objectItem.setObjectName(item.objectName());
                objectItem.setSize(item.size());
                objectItems.add(objectItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return objectItems;
    }

    /**
     * 批量删除文件对象
     *
     * @param bucketName 存储bucket名称
     * @param objects    对象名称集合
     */
    public Iterable<Result<DeleteError>> removeObjects(String bucketName, List<String> objects) {
        List<DeleteObject> dos = objects.stream().map(e -> new DeleteObject(e)).collect(Collectors.toList());
        return minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(dos).build());
    }

    /**
     * 根据文件名和桶获取文件路径
     *
     * @param bucketName 存储bucket名称
     */
    public String getFileUrl(String bucketName, String objectFile) {
        try {
            if(StringUtils.isEmpty(bucketName)){
                bucketName = minioProperties.getBucketName();
            }
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(bucketName)
                    .object(objectFile)
                    .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}