package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * The BinaryTreeNode class describes
 * the properties of a binary tree node
 *
 * @author Waswa Olunga
 */

public class BinaryTreeNode {

	private static final int MAX_NUM_DEPTHS = 2;

	private BinaryTreeNode right;
	private BinaryTreeNode left;
	private int nodeValue;

	public BinaryTreeNode(int nodeValue){
		this.nodeValue = nodeValue;
	}

	public BinaryTreeNode insertRight(BinaryTreeNode right) {
		this.right = right;
		return this.right;
	}

	public BinaryTreeNode insertLeft(BinaryTreeNode left) {
		this.left = left;
		return this.left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public boolean isSuperBalanced(){

		Stack<NodeAndDepthPair> nodeAndDepthPairs = new Stack<>();
		List<Integer> depths = new ArrayList<>(MAX_NUM_DEPTHS);
		nodeAndDepthPairs.push(new NodeAndDepthPair(this, nodeValue));

		while (!nodeAndDepthPairs.isEmpty()){

			NodeAndDepthPair currentNodeAndDepthPair = nodeAndDepthPairs.pop();
			BinaryTreeNode currentNode = currentNodeAndDepthPair.getNode();
			int currentDepth = currentNodeAndDepthPair.getDepth();

			if (currentNode.getLeft() == null && currentNode.getRight() == null) {
				if (SuperBalancedFunctionality.isLeafUnbalanced(depths, currentDepth)) {
					return false;
				}
			} else {
				SuperBalancedFunctionality.addChildNodes(nodeAndDepthPairs,
														 currentNode, currentDepth);
			}

		}

		return true;
	}

}