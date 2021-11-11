package com.relyy.algorithm.binaryTreeTraversal;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Description 遍历二叉树 -- 迭代法
 * @Created by cairuirui
 * @Date 2021/11/11
 */
public class TreeTraversalByIteration {

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
		System.out.println(postOrder(tree));
	}

	/**
	 * 前序遍历
	 * @param binaryTree
	 */
	public static List<Integer> preOrder(BinaryTree<Integer> binaryTree){
		// 根节点 左右节点
		//直接先输出根节点,如果左节点不为空，输出左节点
		//右节点入栈
		BinaryTreeNode<Integer> rootNode = binaryTree.rootNode;
		LinkedList<BinaryTreeNode> nodeList = new LinkedList<>();
		nodeList.push(rootNode);
		List<Integer> result = Lists.newArrayList();

		while (!nodeList.isEmpty()){
			BinaryTreeNode pop = nodeList.pop();
			result.add((Integer)pop.t);
			//System.out.println(pop.t);
			if (pop.rightChild != null){
				nodeList.push(pop.rightChild);
			}
			if (pop.leftChild != null){
				nodeList.push(pop.leftChild);
			}
		}
		nodeList = null;
		return result;
	}

	public static List<Integer> midOrder(BinaryTree<Integer> binaryTree){
		// 根节点 左右节点
		//左子节点为空 则输出，再查看右子节点
		//右节点入栈
		BinaryTreeNode<Integer> rootNode = binaryTree.rootNode;
		LinkedList<BinaryTreeNode> nodeList = new LinkedList<>();
		Set<BinaryTreeNode> hashSet = new HashSet<>();
		List<Integer> result = Lists.newArrayList();
		nodeList.push(rootNode);

		while (!nodeList.isEmpty()){
			BinaryTreeNode pop = nodeList.pop();

			if (pop.leftChild != null && !hashSet.contains(pop.leftChild)){
				nodeList.push(pop);
				nodeList.push(pop.leftChild);
			}else {
				if (pop.rightChild != null){
					nodeList.push(pop.rightChild);
				}
				hashSet.add(pop);
				result.add((Integer)pop.t);
			}
		}
		nodeList = null;
		hashSet = null;
		return result;
	}

	public static List<Integer> postOrder(BinaryTree<Integer> binaryTree){
		// 根节点 左右节点
		//左右子节点为空 则输出
		BinaryTreeNode<Integer> rootNode = binaryTree.rootNode;
		LinkedList<BinaryTreeNode> nodeList = new LinkedList<>();
		Set<BinaryTreeNode> hashSet = new HashSet<>();
		List<Integer> result = Lists.newArrayList();
		nodeList.push(rootNode);

		while (!nodeList.isEmpty()){
			BinaryTreeNode pop = nodeList.peek();
			BinaryTreeNode leftChild = pop.leftChild;
			BinaryTreeNode rightChild = pop.rightChild;
			boolean needPop = true;
			if (rightChild != null && !hashSet.contains(rightChild)){
				nodeList.push(rightChild);
				needPop = false;
			}
			if (leftChild != null && !hashSet.contains(leftChild)){
				nodeList.push(leftChild);
				needPop = false;
			}
			if (needPop){
				nodeList.pop();
				hashSet.add(pop);
				result.add((Integer)pop.t);
			}
		}
		nodeList = null;
		hashSet = null;
		return result;
	}
}
