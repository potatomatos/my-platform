package cn.cxnxs.scheduler.exception;

import cn.cxnxs.common.core.entity.response.Result;

/**
 * <p>登录异常</p>
 *
 * @author mengjinyuan
 * @date 2020-11-25 11:11
 **/
public class LoginException extends RuntimeException {

    private Integer code = Result.ResultEnum.SYSTEM_EXCEPTION.getCode();

    public LoginException(String s) {
        super(s);
    }

    public LoginException(Result.ResultEnum resultEnum) {
        super(resultEnum.getInfo());
        this.code = resultEnum.getCode();
    }

    public LoginException(Result.ResultEnum resultEnum, String s) {
        super(s);
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
