package com.able.re.DataStructureAndAlgorithms.binaryTreeTraversal;

/**
 * 二叉树节点
 *
 * @author cairuirui
 * @create 2019/3/5
 */
public class BinaryTreeNode<T> {
    /**
     * 节点的值
     */

    T t;
    /**
     * 左子节点
     */

    BinaryTreeNode leftChild;
    /**
     * 右子节点
     */
    BinaryTreeNode rightChild;

    /**
     * 父节点
     */
    BinaryTreeNode parentId;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T t) {
        this.t = t;
        this.leftChild = null;
        this.rightChild = null;
        this.parentId = null;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getParentId() {
        return parentId;
    }

    public void setParentId(BinaryTreeNode parentId) {
        this.parentId = parentId;
    }
}
