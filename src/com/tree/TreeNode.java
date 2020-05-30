package com.tree;

import java.util.List;

/**
 * 树节点
 *
 * @author JTMAD
 * @date 2020-05-22-16:23
 */
public interface TreeNode {

  /**
   * 是否根节点
   * @return
   */
  boolean isRoot();

  /**
   * 是否叶子节点
   * @return
   */
  boolean isLeaf();
}
