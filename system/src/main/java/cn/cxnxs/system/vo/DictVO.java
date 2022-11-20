package cn.cxnxs.system.vo;

import cn.cxnxs.common.core.entity.TreeVo;

import java.util.Objects;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-26 22:50
 **/
public class DictVO extends TreeVo {

    private Integer id;
    private String dictType;
    private String code;
    private String label;
    private Integer state;
    private Integer sort;
    private Long createdAt;
    private Long updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictVO dictVO = (DictVO) o;
        return Objects.equals(id, dictVO.id) &&
                Objects.equals(dictType, dictVO.dictType) &&
                Objects.equals(code, dictVO.code) &&
                Objects.equals(label, dictVO.label) &&
                Objects.equals(state, dictVO.state) &&
                Objects.equals(sort, dictVO.sort) &&
                Objects.equals(createdAt, dictVO.createdAt) &&
                Objects.equals(updatedAt, dictVO.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dictType, code, label, state, sort, createdAt, updatedAt);
    }
}
