package cn.cxnxs.scheduler.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GraphNode {

    private Integer id;

    private String name;

    private Integer type;

    private String typeName;

    private Long eventCount;
}
