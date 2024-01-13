package cn.cxnxs.common.core.utils;


import cn.cxnxs.common.core.entity.TreeVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>树形菜单工具</p>
 *
 * @author mengjinyuan
 * @date 2020-11-11 15:33
 **/
public class TreeUtil {

    public static <T extends TreeVo> List<T> toTreeVo(List<T> treeList, Object pid) {
        List<T> retList = new ArrayList<>();
        for (T parent : treeList) {
            if (pid.equals(parent.getParentNodeId())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }

    private static <T extends TreeVo> T findChildren(T parent, List<T> treeList) {
        for (T child : treeList) {
            if (parent.getNodeId().equals(child.getParentNodeId())) {
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(findChildren(child, treeList));
            }
        }
        return parent;
    }

    /**
     * 递归遍历获取指定的所有父节点
     *
     * @param trees  树
     * @param treeId 子节点ID
     */
    public static List<Object> queryParentIds(Object treeId, List<TreeVo> trees) {
        //递归获取父级ids,不包含自己
        List<Object> parentIds = new ArrayList<>();
        treeParent(trees, treeId, parentIds);
        return parentIds;
    }

    /**
     * 递归获取父级ids
     *
     * @param trees
     * @param treeId
     * @param parentIds
     */
    private static void treeParent(List<TreeVo> trees, Object treeId, List<Object> parentIds) {
        for (TreeVo tree : trees) {
            if (tree.getParentNodeId() == null) {
                continue;
            }
            //判断是否有父节点
            if (tree.getNodeId().equals(treeId)) {
                parentIds.add(tree.getParentNodeId());
                treeParent(trees, tree.getParentNodeId(), parentIds);
            }
        }
    }
}
