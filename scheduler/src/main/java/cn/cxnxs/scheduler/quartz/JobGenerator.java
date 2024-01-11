package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentType;
import cn.cxnxs.scheduler.utils.SpringContextUtil;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>任务生成器</p>
 *
 * @author mengjinyuan
 * @date 2021-02-04 11:35
 **/
@Component
public class JobGenerator {

    private static final Logger logger = LoggerFactory.getLogger(JobGenerator.class);

    public IAgent buildAgent(AgentVo agent) throws ClassNotFoundException {
        Integer typeId = agent.getType();
        ScheduleAgentType scheduleAgentType = new ScheduleAgentType().selectById(typeId);
        logger.info("创建代理实例:{}", scheduleAgentType.getHandler());
        Class<IAgent> agentClass = (Class<IAgent>) Class.forName(scheduleAgentType.getHandler());
        IAgent agentInstance = SpringContextUtil.getBean(agentClass);
        agentInstance.option(JSONObject.parseObject(agent.getOptions()));
        return agentInstance.option(JSONObject.parseObject(agent.getOptions()));
    }
}
