package model;

import java.util.List;
import java.util.Stack;

/**
 * The SuperBalancedFunctionality class
 * describes the methods required
 * to determine if a binary tree is
 * super balanced
 *
 * @author Waswa Olunga
 */

public class SuperBalancedFunctionality {

	private static final int MAX_NUM_DEPTHS = 2;
	private static final int MAX_DEPTH_DIFFERENCE = 1;

	public static boolean isLeafUnbalanced(List<Integer> depths, int currentDepth) {
		if (!depths.contains(currentDepth)){
			if (isMaxNumDepths(depths, currentDepth)){
				return true;
			}
		}

		return isDepthDifferenceGreaterThanOne(depths);
	}

	private static boolean isMaxNumDepths(List<Integer> depths, int currentDepth) {

		if (depths.size() == MAX_NUM_DEPTHS){
			return true;
		} else {
			depths.add(currentDepth);
		}
		return false;
	}

	private static boolean isDepthDifferenceGreaterThanOne(List<Integer> depths) {

		int firstDepth = depths.get(0);
		int secondDepth = depths.get(1);

		return Math.abs(secondDepth - firstDepth) > MAX_DEPTH_DIFFERENCE;
	}

	public static void addChildNodes(Stack<NodeAndDepthPair> nodeAndDepthPairs,
	                                 BinaryTreeNode currentNode, int currentDepth) {

		BinaryTreeNode rightNode = currentNode.getRight();
		BinaryTreeNode leftNode = currentNode.getLeft();
		int childNodeDepth = currentDepth + 1;

		if (rightNode != null) {
			nodeAndDepthPairs.push(new NodeAndDepthPair(rightNode, childNodeDepth));
		}

		if (leftNode != null) {
			nodeAndDepthPairs.push(new NodeAndDepthPair(leftNode, childNodeDepth));
		}
	}

}
