package cn.cxnxs.common.core.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * <p>树形菜组件实体</p>
 *
 * @author mengjinyuan
 * @date 2020-11-12 17:06
 **/
public class TreeVo {

    /**
     * 节点唯一索引值，用于对指定节点进行各类操作
     */
    private Object nodeId;

    /**
     * 上级id
     */
    private Object parentNodeId;
    /**
     * 节点标题
     */
    private String title;

    /**
     * 节点字段名
     */
    private String field;

    /**
     * 点击节点弹出新窗口对应的 url。需开启 isJump 参数
     */
    private String href;

    /**
     * 图标
     */
    private String icon;

    /**
     * 节点是否初始展开，默认 false
     */
    private Boolean spread;

    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private Boolean checked;

    /**
     * 节点是否为禁用状态。默认 false
     */
    private Boolean disabled;

    /**
     * 是否叶子节点
     */
    private Boolean leaf;

    /**
     * 类型-预留用
     */
    private Integer type;

    /**
     * 拓展数据
     */
    private JSONObject expandData;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 子节点。支持设定选项同父节点
     */
    private List<TreeVo> children;


    public Object getNodeId() {
        return nodeId;
    }

    public void setNodeId(Object nodeId) {
        this.nodeId = nodeId;
    }

    public Object getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Object parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public JSONObject getExpandData() {
        return expandData;
    }

    public void setExpandData(JSONObject expandData) {
        this.expandData = expandData;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public List<TreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVo> children) {
        this.children = children;
    }
}
