package com.relyy.algorithm.binaryTreeTraversal;

import java.util.LinkedList;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/3/5
 */
public class TreeTraversal {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        levelTraversal(tree.rootNode);
        preTraversal(tree.rootNode);
        middleTraversal(tree.rootNode);
        postTraversal(tree.rootNode);

        //recursionPre(tree.rootNode);
        //recursionMid(tree.rootNode);
        //recursionPost(tree.rootNode);
    }

    /**
     * 层次遍历
     * @param rootNode
     */
    public static void levelTraversal(BinaryTreeNode<Integer> rootNode){
        if (rootNode == null) {
            return;
        }

        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.offer(rootNode);
        //BinaryTreeNode<Integer> node = rootNode;
        while (!list.isEmpty()){
            BinaryTreeNode binaryTreeNode = list.poll();
            if (binaryTreeNode != null){
                System.out.print(binaryTreeNode.getT());
                if (binaryTreeNode.leftChild != null){
                    list.offer(binaryTreeNode.leftChild);
                }
                if (binaryTreeNode.rightChild != null){
                    list.offer(binaryTreeNode.rightChild);
                }
            }

        }
    }

    /**
     * 前向遍历
     * @param rootNode
     */
    public static void preTraversal(BinaryTreeNode<Integer> rootNode){

        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        BinaryTreeNode<Integer> node = rootNode;
        while (node != null || !list.isEmpty()){
            if (node != null){
                System.out.println(node.getT());
                list.push(node);
                node = node.leftChild;
            }else {
                BinaryTreeNode<Integer> pnode = list.pop();
                node = pnode.rightChild;
            }
        }

    }

    /**
     * 中序遍历
     * @param rootNode
     */
    public static void middleTraversal(BinaryTreeNode<Integer> rootNode){
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        BinaryTreeNode<Integer> node = rootNode;
        while (node != null || !list.isEmpty()){
            if (node != null){
                list.push(node);
                node = node.leftChild;
            }else {
                BinaryTreeNode pre = list.pop();
                System.out.println(pre.getT());
                node = pre.rightChild;
            }
        }
    }

    /**
     * 后序遍历
     * @param rootNode
     */
    public static void postTraversal(BinaryTreeNode<Integer> rootNode){
        if (rootNode == null) return;
        BinaryTreeNode pre = null;
        BinaryTreeNode cur = null;
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.push(rootNode);
        while (!list.isEmpty()){
            cur = list.peek();
            if ((cur.leftChild == null && cur.rightChild == null) ||
                    (pre != null && (pre == cur.leftChild || pre == cur.rightChild))){
                System.out.println(cur.getT());
                list.pop();
                pre = cur;
            }else {

                if (cur.rightChild != null) {
                    list.push(cur.rightChild);
                }
                if (cur.leftChild != null) {
                    list.push(cur.leftChild);
                }
            }
        }
    }

    /**--------------递归版本--------------------**/
    public static void recursionPre(BinaryTreeNode<Integer> rootNode){
        if (rootNode != null) {
            System.out.println(rootNode.getT());
            recursionPre(rootNode.leftChild);
            recursionPre(rootNode.rightChild);
        }
    }

    public static void recursionMid(BinaryTreeNode<Integer> rootNode){
        if (rootNode != null) {
            recursionMid(rootNode.leftChild);
            System.out.println(rootNode.getT());
            recursionMid(rootNode.rightChild);
        }
    }

    public static void recursionPost(BinaryTreeNode<Integer> rootNode){
        if (rootNode != null) {
            recursionPost(rootNode.leftChild);
            recursionPost(rootNode.rightChild);
            System.out.println(rootNode.getT());
        }
    }
}
