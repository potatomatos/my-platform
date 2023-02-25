package cn.cxnxs.telegram.vo.response;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2021-10-14 23:10
 **/
public class LoginResponse implements Serializable {

    /**
     * 0成功
     * 1失败
     * 2超时
     */
    private Integer stateCode;

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "stateCode=" + stateCode +
                '}';
    }
}
