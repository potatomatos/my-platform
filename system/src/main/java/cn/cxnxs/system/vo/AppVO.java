package cn.cxnxs.system.vo;

import lombok.Data;

@Data
public class AppVO {

    private Long id;

    private String appName;

    private String homePage;

    private Long createdAt;

    private Long updatedAt;
}
