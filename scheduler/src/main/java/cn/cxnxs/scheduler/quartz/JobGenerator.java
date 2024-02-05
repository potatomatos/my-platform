package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.utils.SpringContextUtil;
import cn.cxnxs.scheduler.vo.AgentVo;
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
        logger.info("创建任务实例:{}", agent.getAgentType().getHandler());
        IAgent agentInstance = SpringContextUtil.getBean(agent.getAgentType().getHandlerClass());
        agentInstance.setName(agent.getName());
        return agentInstance.option(agent.getOptionsJSON());
    }
}
