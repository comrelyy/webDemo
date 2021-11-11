package com.relyy.algorithm.binaryTreeTraversal;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description  遍历二叉树 -- 递归
 * @Created by cairuirui
 * @Date 2021/11/11
 */
public class TreeTraversalByRecursive {
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
		System.out.println(preOrder(tree.rootNode, Lists.newArrayList()));
		System.out.println(midOrder(tree.rootNode, Lists.newArrayList()));
		System.out.println(postOrder(tree.rootNode, Lists.newArrayList()));
	}

	public static List<Integer> preOrder(BinaryTreeNode<Integer> node,List<Integer> list) {
		if (null == node) return list;
		list.add(node.t);
		preOrder(node.leftChild,list);
		preOrder(node.rightChild,list);
		return list;
	}

	public static List<Integer> midOrder(BinaryTreeNode<Integer> node,List<Integer> list) {
		if (null == node) return list;
		midOrder(node.leftChild,list);
		list.add(node.t);
		midOrder(node.rightChild,list);
		return list;
	}

	public static List<Integer> postOrder(BinaryTreeNode<Integer> node,List<Integer> list) {
		if (null == node) return list;
		postOrder(node.leftChild,list);
		postOrder(node.rightChild,list);
		list.add(node.t);
		return list;
	}
}
