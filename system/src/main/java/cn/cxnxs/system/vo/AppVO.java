package cn.cxnxs.system.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AppVO {

    @NotEmpty(message = "应用名不能为空")
    protected String appName;

    protected String homePage;

    protected Long createdAt;

    protected Long updatedAt;
}
