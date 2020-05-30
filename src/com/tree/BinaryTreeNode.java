package com.tree;

import java.util.Objects;

/**
 * 二叉树节点
 *
 * @author JTMAD
 * @date 2020-05-22-16:32
 */
public class BinaryTreeNode implements TreeNode{

  private BinaryTreeNode parent;

  private Object data;

  private BinaryTreeNode left;

  private BinaryTreeNode right;

  @Override
  public boolean isRoot() {
    return Objects.isNull(parent);
  }

  @Override
  public boolean isLeaf() {
    return Objects.isNull(left) && Objects.isNull(right);
  }

  public Object getData() {
    return data;
  }

  public BinaryTreeNode getParent() {
    return parent;
  }

  public void setParent(BinaryTreeNode parent) {
    this.parent = parent;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public BinaryTreeNode getLeft() {
    return left;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode getRight() {
    return right;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }

  public boolean hasLeft() {
    return !Objects.isNull(left);
  }

  public boolean hasRight() {
    return !Objects.isNull(right);
  }
}
