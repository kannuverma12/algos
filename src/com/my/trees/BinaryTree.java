package com.my.trees;

//Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/
class Node {
	int data;
	Node2 left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

/* Class to print the left view */
class BinaryTree {
	Node2 root;
	static int max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node2 node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node2(12);
		tree.root.left = new Node2(10);
		tree.root.right = new Node2(30);
		tree.root.right.left = new Node2(25);
		tree.root.right.right = new Node2(40);

		tree.leftView();
	}
}