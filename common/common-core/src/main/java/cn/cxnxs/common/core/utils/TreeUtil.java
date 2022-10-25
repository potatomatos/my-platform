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

    public static List<TreeVo> toTreeVo(List<TreeVo> treeList, Integer pid) {
        List<TreeVo> retList = new ArrayList<>();
        for (TreeVo parent : treeList) {
            if (pid.equals(parent.getPid())) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }

    private static TreeVo findChildren(TreeVo parent, List<TreeVo> treeList) {
        for (TreeVo child : treeList) {
            if (parent.getId().equals(child.getPid())) {
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
    public static List<Integer> queryParentIds(Integer treeId, List<TreeVo> trees) {
        //递归获取父级ids,不包含自己
        List<Integer> parentIds = new ArrayList<>();
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
    private static void treeParent(List<TreeVo> trees, Integer treeId, List<Integer> parentIds) {
        for (TreeVo tree : trees) {
            if (tree.getPid() == null) {
                continue;
            }
            //判断是否有父节点
            if (tree.getId().equals(treeId)) {
                parentIds.add(tree.getPid());
                treeParent(trees, tree.getPid(), parentIds);
            }
        }
    }
}
