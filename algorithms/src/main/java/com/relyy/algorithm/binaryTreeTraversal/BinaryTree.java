package com.relyy.algorithm.binaryTreeTraversal;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * @author cairuirui
 * @create 2019/3/5
 */
public class BinaryTree<T> {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    BinaryTreeNode<T> rootNode;

    int level;

    int size;

    int index;

    BinaryTreeNode<T>[] table = null;

    public BinaryTree() {
        try{
            this.rootNode = new BinaryTreeNode<T>();
            this.table = new BinaryTreeNode[32];
            this.table[0] = rootNode;
            this.size = 0;
            this.level = 0;
            this.index = 0;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public BinaryTree(BinaryTreeNode<T> rootNode) {
        this(rootNode,1);
    }

    public BinaryTree(BinaryTreeNode<T> rootNode, int level) {
        this.rootNode = rootNode;
        this.level = level;
        this.size = 2 << level  - 1;
        table = new BinaryTreeNode[size];
        table[0] = rootNode;
        this.index= 1;
    }

    public boolean addNode(T t){
        BinaryTreeNode<T> tBinaryTreeNode = new BinaryTreeNode<>(t);
        if (index == 0){
            table[index] = tBinaryTreeNode;
            rootNode = tBinaryTreeNode;
        }else {
            table[index] = tBinaryTreeNode;
            int parentIndex = 0;
            BinaryTreeNode<T> parentNode = null;
            if (index % 2 == 1) {
                parentIndex = (index - 1) / 2;
                parentNode = table[parentIndex];
                parentNode.setLeftChild(tBinaryTreeNode);
            } else {
                parentIndex = (index - 2) / 2;
                parentNode = table[parentIndex];
                parentNode.setRightChild(tBinaryTreeNode);
            }
            tBinaryTreeNode.setParentId(parentNode);
        }
        index++;
        size++;
        if (((2 << level)  - 1) < size){
            level ++;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("BinaryTree{");
        if (table != null) {
            for (BinaryTreeNode<T> tBinaryTreeNode : table) {
                if (tBinaryTreeNode != null && tBinaryTreeNode.getT() != null) {
                    sb.append(tBinaryTreeNode.getT()).append(",");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public void LevelToString(){
        if (rootNode != null){
            List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
            binaryTreeNodes.add(rootNode);
            this.levelPrint(binaryTreeNodes);
        }
    }

    private void levelPrint(List<BinaryTreeNode> binaryTreeNodes){
        if (CollectionUtils.isNotEmpty(binaryTreeNodes)) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("{");
            List<BinaryTreeNode> childrenNode = new ArrayList<>();
            for (BinaryTreeNode binaryTreeNode : binaryTreeNodes) {
                buffer.append(binaryTreeNode.getT()).append(",");
                BinaryTreeNode rightChild = binaryTreeNode.getRightChild();
                if (rightChild != null){
                    childrenNode.add(rightChild);
                }
                BinaryTreeNode leftChild = binaryTreeNode.getLeftChild();
                if (leftChild != null){
                    childrenNode.add(leftChild);
                }
            }
            buffer.append("}");
            System.out.println(buffer.toString());
            levelPrint(childrenNode);
            return;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.addNode(1);
        integerBinaryTree.addNode(2);
        integerBinaryTree.addNode(3);
        integerBinaryTree.addNode(4);
        integerBinaryTree.LevelToString();
    }

//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1; //无符号右移后，或
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
}
