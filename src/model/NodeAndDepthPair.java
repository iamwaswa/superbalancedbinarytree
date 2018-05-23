package model;

/**
 * The NodeAndDepthPair class describes
 * a binary tree node and its depth
 * in the binary tree
 *
 * @author Waswa Olunga
 */
public class NodeAndDepthPair {

	private BinaryTreeNode node;
	private int depth;

	public NodeAndDepthPair(BinaryTreeNode node, int depth) {
		this.node = node;
		this.depth = depth;
	}

	public BinaryTreeNode getNode() {
		return node;
	}

	public int getDepth() {
		return depth;
	}

}