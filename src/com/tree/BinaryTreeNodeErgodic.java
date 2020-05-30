package com.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树的遍历
 *
 * @author JTMAD
 * @date 2020-05-22-16:52
 */
public class BinaryTreeNodeErgodic {

  public static void main(String[] args) {
    BinaryTreeNode node41 = getTreeNode("8");
    BinaryTreeNode node42 = getTreeNode("9");
    BinaryTreeNode node43 = getTreeNode("10");
    BinaryTreeNode node31 = getTreeNode("4", node41, node42);
    BinaryTreeNode node32 = getTreeNode("5", node43);
    BinaryTreeNode node33 = getTreeNode("6");
    BinaryTreeNode node34 = getTreeNode("7");
    BinaryTreeNode node21 = getTreeNode("2", node31, node32);
    BinaryTreeNode node22 = getTreeNode("3", node33, node34);
    BinaryTreeNode node11 = getTreeNode("1", node21, node22);

    preOrderErgodic(node11);System.out.println("");
    midOrderErgodic(node11);System.out.println("");
    postOrderErgodic(node11);System.out.println("");
    Queue queue = new LinkedList();
    queue.add(node11);
    levelOrderErgodic(queue);System.out.println("");
  }

  /**
   * 前序遍历
   */
  private static void preOrderErgodic(BinaryTreeNode treeNode) {
    if (Objects.isNull(treeNode)) {
      return;
    }
    System.out.print(treeNode.getData());
    preOrderErgodic(treeNode.getLeft());
    preOrderErgodic(treeNode.getRight());
  }

  /**
   * 中序遍历
   */
  private static void midOrderErgodic(BinaryTreeNode treeNode) {
    if (Objects.isNull(treeNode)) {
      return;
    }
    midOrderErgodic(treeNode.getLeft());
    System.out.print(treeNode.getData());
    midOrderErgodic(treeNode.getRight());
  }

  /**
   * 后续遍历
   */
  private static void postOrderErgodic(BinaryTreeNode treeNode) {
    if (Objects.isNull(treeNode)) {
      return;
    }
    postOrderErgodic(treeNode.getLeft());
    postOrderErgodic(treeNode.getRight());
    System.out.print(treeNode.getData());
  }

  /**
   * 层序遍历
   */
  private static void levelOrderErgodic(Queue<BinaryTreeNode> queue) {
    if (queue.isEmpty()) {
      return;
    }
    BinaryTreeNode peek = queue.poll();
    System.out.print(peek.getData());
    if (peek.hasLeft()) {
      queue.add(peek.getLeft());
    }
    if (peek.hasRight()) {
      queue.add(peek.getRight());
    }
    levelOrderErgodic(queue);
  }


  private static  BinaryTreeNode getTreeNode(Object data, BinaryTreeNode... treeNodes){
    BinaryTreeNode treeNode = new BinaryTreeNode();
    treeNode.setData(data);
    if (treeNodes.length > 0) {
      treeNode.setLeft(treeNodes[0]);
      treeNodes[0].setParent(treeNode);
      if (treeNodes.length > 1) {
        treeNode.setRight(treeNodes[1]);
        treeNodes[1].setParent(treeNode);
      }
    }
    return treeNode;
  }
}
