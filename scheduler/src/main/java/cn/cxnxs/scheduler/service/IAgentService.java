package cn.cxnxs.scheduler.service;

import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.exception.AgentNotFoundException;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 爬虫任务配置信息 服务类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface IAgentService extends IService<ScheduleAgent> {

    /**
     * 获取agent配置信息
     *
     * @param agentType agent类型
     * @return
     */
    Map<String, Object> getAgentConfig(String agentType);


    /**
     * 查询所有
     *
     * @param agentTypeVo 查询条件
     * @return none
     */
    List<AgentVo> findByTypeProperties(AgentTypeVo agentTypeVo);

    /**
     * 保存代理
     *
     * @param agentVo 代理数据
     * @return none
     */
    Map<String, String> saveAgent(AgentVo agentVo);

    /**
     * 根据id获取代理
     *
     * @param id 主键
     * @return none
     */
    AgentVo getAgentById(Integer id) throws AgentNotFoundException;

    /**
     * 分页查询
     *
     * @param agentVo 入参
     * @return none
     */
    Result<List<AgentVo>> pageList(AgentVo agentVo);

    /**
     * 测试运行
     *
     * @param type    任务类型
     * @param options 任务配置
     * @return 解析数据结果
     */
    List<Map<String, String>> dryRun(Integer type, JSONObject options, JSONObject payload) throws AgentNotFoundException, ClassNotFoundException, HttpProcessException;

}
