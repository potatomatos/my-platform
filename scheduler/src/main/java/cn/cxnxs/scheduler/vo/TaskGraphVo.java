package cn.cxnxs.scheduler.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskGraphVo {

    /**
     * 节点数据
     */
    List<GraphNode> nodeList;

    /**
     * 节点连接线
     */
    List<GraphLink> linkList;

    public TaskGraphVo() {
    }

    public TaskGraphVo(List<GraphNode> nodeList, List<GraphLink> linkList) {
        this.nodeList = nodeList;
        this.linkList = linkList;
    }
}
