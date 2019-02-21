package com.github.manage.common.util;

import com.github.manage.vo.MenuVo;

import java.util.*;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.util
 * @Description: 构建树
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
public class TreeBuilder {

    public static List<MenuVo> findRoots(List<MenuVo> allNodes) {
        // 根节点
        List<MenuVo> root = new ArrayList<>();
        allNodes.forEach(node -> {
            if (node.getParentId() == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static MenuVo findChildren(MenuVo rootNode, List<MenuVo> treeNodes) {
        for (MenuVo menuVo : treeNodes) {
            if (rootNode.getId().equals(menuVo.getParentId())) {
                if (rootNode.getChildren() == null) {
                    rootNode.setChildren(new ArrayList<>());
                }
                rootNode.getChildren().add(findChildren(menuVo, treeNodes));
            }
        }
        return rootNode;
    }


    public static void main(String[] args) {
//        Set<MenuVo> set = new HashSet<>();
//        set.addAll(Arrays.asList(
//                new MenuVo(1, 0, "一级", "", ""),
//                new MenuVo(2, 0, "一级", "", ""),
//                new MenuVo(3, 1, "二级", "", ""),
//                new MenuVo(4, 1, "二级", "", ""),
//                new MenuVo(4, 2, "二级", "", ""),
//                new MenuVo(6, 2, "二级", "", ""),
//                new MenuVo(7, 3, "三级", "", ""),
//                new MenuVo(8, 4, "三级", "", ""),
//                new MenuVo(9, 5, "三级", "", ""),
//                new MenuVo(10, 6, "三级", "", ""),
//                new MenuVo(11, 6, "三级", "", "")
//        ));
//
//        for (MenuVo menuVo : findRoots(set)) {
//            System.out.println(menuVo);
//        }

    }


}