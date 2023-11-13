package com.example;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> left, right;
	
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		this.data = dataNode;
	}
	
	public TreeNode(TreeNode<T> node) {
		if (node.left != null)
			this.left = new TreeNode<T>(node.left);
		else
			this.left = null;

		if (node.right != null)
			this.right = new TreeNode<T>(node.left);
		else
			this.right = null;

		if (node.data != null) {
			T newData = (T) new Object();
			newData = node.data;
			this.data = newData;
		}
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	
}
