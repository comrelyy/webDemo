package com.relyy.algorithm.binaryTreeTraversal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的层次遍历
 */
public class TreeTraversalBylevel {

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
        System.out.println(tree.toString());
        System.out.println(levelTraversal1(tree.rootNode));
    }


    public static List<List<Integer>> levelTraversal1(BinaryTreeNode<Integer> rootNode){
        List<List<Integer>> result = Lists.newArrayList();
        LinkedList<BinaryTreeNode<Integer>> linkedList = new LinkedList<>();
        linkedList.offer(rootNode);
        linkedList.offer(new BinaryTreeNode<>(null));
        List<Integer> list = null;//Lists.newArrayList();
        while (!linkedList.isEmpty()){
            BinaryTreeNode<Integer> pop = linkedList.poll();
            if (null != pop) {
                if (null != pop.t) {
                    if (null == list) list = new ArrayList<>();
                    list.add(pop.t);
                    if (pop.leftChild != null) linkedList.offer(pop.leftChild);
                    if (pop.rightChild != null) linkedList.offer(pop.rightChild);
                } else {
                    result.add(list);
                    if (linkedList.isEmpty()) {
                        break;
                    }
                    linkedList.offer(new BinaryTreeNode<>(null));
                    list = Lists.newArrayList();
                }
            }
        }
        return result;
    }

    
}
