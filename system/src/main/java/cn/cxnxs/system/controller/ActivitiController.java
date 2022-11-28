package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.vo.ActivitiModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-11-27 21:33
 **/
@RestController
@RequestMapping("/activiti")
public class ActivitiController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 创建模型
     */
    @ResponseResult
    @RequestMapping("/create")
    public Result<String> create(@RequestBody ModelEntity modelEntity) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        Model modelData = repositoryService.newModel();

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelEntity.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelEntity.getVersion());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, modelEntity.getMetaInfo());
        modelData.setMetaInfo(modelObjectNode.toString());
        modelData.setName(modelEntity.getName());
        modelData.setKey(modelEntity.getKey());
        modelData.setVersion(modelEntity.getVersion());

        //保存模型
        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes(StandardCharsets.UTF_8));

        return Result.success("模型创建成功", modelData.getId());
    }

    /**
     * 模型列表
     *
     * @param @return
     * @return Object
     * @throws
     * @author：tuzongxun
     * @Title: modelList
     * @date Mar 17, 2016 12:29:52 PM
     */
    @ResponseResult
    @PostMapping("modelList")
    public PageResult<ModelEntity> modelList(@RequestBody PageWrapper<ActivitiModel> pageWrapper) {
        List<ModelEntity> modelList = new ArrayList<>();
        ModelQuery modelQuery = repositoryService.createModelQuery().latestVersion().orderByLastUpdateTime().desc();
        List<Model> list = modelQuery.listPage((pageWrapper.getPage() - 1) * pageWrapper.getLimit(),
                pageWrapper.getLimit());
        if (list != null && list.size() > 0) {
            for (Model model : list) {
                ModelEntity activitiModel = new ModelEntity();
                activitiModel.setId(model.getId());
                activitiModel.setCreateTime(model.getCreateTime());
                activitiModel.setMetaInfo(model.getMetaInfo());
                activitiModel.setKey(model.getKey());
                activitiModel.setLastUpdateTime(model.getLastUpdateTime());
                activitiModel.setName(model.getName());
                activitiModel.setVersion(model.getVersion());
                modelList.add(activitiModel);
            }
        }
        PageResult<ModelEntity> result = new PageResult<>(modelQuery.count());
        result.setRows(modelList);
        result.setCurrent((long) pageWrapper.getPage());
        result.setPageSize((long) pageWrapper.getLimit());
        return result;
    }

    /**
     * 删除模型
     *
     * @param modelId
     * @return
     */
    @ResponseResult
    @PostMapping("model/{modelId}/del")
    public Integer deleteModel(@PathVariable String modelId) {
        repositoryService.deleteModel(modelId);
        return 1;
    }

    /**
     * 导出下载模型图zip压缩包
     *
     * @param modelId
     */
    @GetMapping("model/{modelId}/export")
    public void export(@PathVariable String modelId) throws IOException {
        // 查询模型信息
        Model model = repositoryService.getModel(modelId);
        if (model != null) {
            // 获取流程图 json 字节码
            byte[] bpmnJsonBytes = repositoryService.getModelEditorSource(modelId);
            // 流程图 json 字节码转 xml 字节码
            byte[] xmlBytes = bpmnJsonToXmlBytes(bpmnJsonBytes);
            if (xmlBytes == null) {
                throw new CommonException("模型数据为空-请先设计完整流程-再导出");
            } else {
                // 压缩包文件名
                String zipName = model.getName() + "." + model.getKey() + ".zip";
                // 文件输出流
                File file = new File("D:/" + zipName);
                FileOutputStream outputStream = new FileOutputStream(file);
                // 实例化zip压缩对象输出流
                ZipOutputStream zipos = new ZipOutputStream(outputStream);
                // 指定压缩包里的 name.bpmn20.xml 文件名
                zipos.putNextEntry(new ZipEntry(model.getName() + ".bpmn20.xml"));
                // 将xml写入压缩流
                zipos.write(xmlBytes);
                // 查询png图片，
                byte[] pngBytes = repositoryService.getModelEditorSourceExtra(modelId);
                if (pngBytes != null) {
                    // 指定压缩包里的 name.key.png 文件名
                    zipos.putNextEntry(new ZipEntry(model.getName() + "." + model.getKey() + ".png"));
                    // 图片文件写到压缩包中
                    zipos.write(pngBytes);
                }
                zipos.closeEntry();
                zipos.close();
            }
        } else {
            throw new CommonException("模型不存在");
        }
    }

    /**
     * 导出xml模型
     *
     * @param modelId
     * @throws Exception
     */
    @GetMapping("model/{modelId}/exportXml")
    public void exportXml(@PathVariable String modelId) throws Exception {
        ByteArrayInputStream in = null;
        // 获取流程图 json 字节码
        byte[] bytes = repositoryService.getModelEditorSource(modelId);
        // json转xml字节数组
        String filename = null;
        if (bytes != null) {
            JsonNode modelNode = objectMapper.readTree(bytes);
            BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            if (bpmnModel.getProcesses().size() != 0) {
                // 转xml字节数组
                byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(bpmnModel);
                in = new ByteArrayInputStream(bpmnBytes);
                // 如果流程名称为空，则取流程定义key
                filename = StringUtils.isEmpty(bpmnModel.getMainProcess().getName()) ?
                        bpmnModel.getMainProcess().getId() : bpmnModel.getMainProcess().getName();
            }
        }
        if (filename == null) {
            filename = "模型数据为空，请先设计流程，再导出";
            in = new ByteArrayInputStream(filename.getBytes(StandardCharsets.UTF_8));
        }
        // 文件输出流
        FileOutputStream out = new FileOutputStream(new File("D:/" + filename + ".bpmn20.xml"));
        // 输入流，输出流的转换
        IOUtils.copy(in, out);
        // 关闭流
        out.close();
        in.close();
        System.out.println("下载模型 xml 文件成功");
    }

    /**
     * 流程部署
     * 流程图保存的时候是json串，引擎认识的却是符合bpmn2.0规范的xml，
     * 所以在首次的部署的时候要将json串转换为BpmnModel，
     * 再将BpmnModel转换成xml保存进数据库，以后每次使用就直接将xml转换成BpmnModel
     */
/*    @GetMapping("model/{modelId}/deploy")
    public void deploy(@PathVariable String modelId) throws Exception {
        // 获取流程图 json 字节码
        byte[] jsonBytes = repositoryService.getModelEditorSource(modelId);
        if (jsonBytes == null) {
            throw new CommonException("模型数据为空，请先设计流程并成功保存，再进行发布。");
        }
        // 转xml字节数组
        byte[] xmlBytes = bpmnJsonToXmlBytes(jsonBytes);
        if (xmlBytes == null) {
            throw new CommonException("数据模型不符要求，请至少设计一条主线流程。");
        }
        // 流程图片字节码
        byte[] pngBytes = repositoryService.getModelEditorSourceExtra(modelId);
        // 获取模型
        Model model = repositoryService.getModel(modelId);
        // 流程定义xml名称
        String processName = model.getName() + ".bpmn20.xml";
        // 流程定义png名称
        String pngName = model.getName() + "." + model.getKey() + ".png";
        // 流程部署
        Deployment deployment = repositoryService.createDeployment()
                .name(model.getName())
                // xml文件
                .addString(processName, new String(xmlBytes, StandardCharsets.UTF_8))
                // 图片
//                .addBytes(pngName, pngBytes)
                .deploy();
        // 更新 部署id 到模型对象（将模型与部署数据绑定）
        model.setDeploymentId(deployment.getId());
        repositoryService.saveModel(model);
        System.out.println("部署完成");
    }*/

    /**
     * 发布流程///流程部署
     *
     * @param modelId 模型ID
     * @return
     */
    @ResponseBody
    @PostMapping("model/{modelId}/deploy")
    public Object publish(@PathVariable String modelId) throws IOException {
        Model modelData = repositoryService.getModel(modelId);//获取相应的模型信息，act_re_model
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());//获取相应的流程文件信息，act_ge_bytearray
        if (bytes == null) {
            throw new CommonException("部署ID:{}的模型数据为空，请先设计流程并成功保存，再进行发布");
        }
        //解析相应的流程文件
        JsonNode modelNode = new ObjectMapper().readTree(bytes);
        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        //部署
        Deployment deployment = repositoryService.createDeployment()
                .name(modelData.getName())//模型名称
                .addBpmnModel(modelData.getKey() + ".bpmn20.xml", model)
                .deploy();//部署相应的流程
        modelData.setDeploymentId(deployment.getId());//获取流程部署后的流程id
        repositoryService.saveModel(modelData);//保存到act_re_model表中
        return 1;
    }

    /**
     * 流程图保存的时候是json串，引擎认识的却是符合bpmn2.0规范的xml，
     * json 字节码转 xml 字节码
     */
    private byte[] bpmnJsonToXmlBytes(byte[] jsonBytes) throws IOException {
        if (jsonBytes == null) {
            return null;
        }
        // json转回BpmnModel对象
        JsonNode modelNode = objectMapper.readTree(jsonBytes);
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if (bpmnModel.getProcesses().size() == 0) {
            return null;
        }
        // BpmnModel对象转xml字节数组
        return new BpmnXMLConverter().convertToXML(bpmnModel);
    }
}
