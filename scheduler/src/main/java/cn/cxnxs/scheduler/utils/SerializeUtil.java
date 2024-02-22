package cn.cxnxs.scheduler.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

/**
 * 对象序列化工具
 */
@Slf4j
public class SerializeUtil {

    /**
     * 序列化对象并转换为Base64字符串
     *
     * @param object
     * @return
     */
    public static String serializeObjectToString(Object object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 反序列化
     *
     * @param str
     * @return
     */
    public static <T> T deserializeObjectFromString(String str) {
        try {
            byte[] data = Base64.getDecoder().decode(str);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                return (T) ois.readObject();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
