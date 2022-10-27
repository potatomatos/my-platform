package cn.cxnxs.system.vo;


import cn.cxnxs.common.web.vo.response.PageResult;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-11 19:38
 **/
public class PageVO<T> extends PageResult<T> {

    /**
     * Datatables发送的draw是多少那么服务器就返回多少。
     * 这里注意，出于安全的考虑，强烈要求把这个转换为整形，即数字后再返回，而不是纯粹的接受然后返回，
     * 这是 为了防止跨站脚本（XSS）攻击。
     */
    private Integer draw;

    public PageVO(Long count) {
        super(count);
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }
}
