package com.example;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		buildTree();
	}
	
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {

			if (code.equals(".")) {
				TreeNode<String> newNode = new TreeNode<String>(letter); 
				root.setLeft(newNode);
			} else if (code.equals("-")) {
				TreeNode<String> newNode = new TreeNode<String>(letter); 
				root.setRight(newNode);
			}

			return;

		} else if (code.length() > 1) {
			TreeNode<String> newRoot = null;
			char firstChar =  code.charAt(0);
			String newCode = null;

			if (firstChar == '.') {
				newRoot = root.getLeft();
				newCode = code.substring(1);
			} else if (firstChar == '-') {
				newRoot = root.getRight();
				newCode = code.substring(1);
			}

			addNode(newRoot, newCode, letter);
		}
		
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() == 1) {
			String letter = null;

			if (code.equals(".")) {
				letter = root.getLeft().getData();
			} else if (code.equals("-")) {
				letter = root.getRight().getData();
			}

			return letter;

		} else if (code.length() > 1) {
			TreeNode<String> newRoot = null;
			char firstChar =  code.charAt(0);
			String newCode = null;

			if (firstChar == '.') {
				newRoot = root.getLeft();
				newCode = code.substring(1);
			} else if (firstChar == '-') {
				newRoot = root.getRight();
				newCode = code.substring(1);
			}

			return fetchNode(newRoot, newCode);
		}

		return "";
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		this.root = new TreeNode<String>("");

		insert(".","e"); insert("-","t"); insert("..","i"); 
		insert(".-","a"); insert("-.","n"); insert("--","m"); 
		insert("...","s"); insert("..-","u"); insert(".-.","r"); 
		insert(".--","w"); insert("-..","d"); insert("-.-","k"); 
		insert("--.","g"); insert("---","o"); insert("....","h"); 
		insert("...-","v"); insert("..-.","f"); insert(".-..","l"); 
		insert(".--.","p"); insert(".---","j"); insert("-...","b"); 
		insert("-..-","x"); insert("-.-.","c"); insert("-.--","y"); 
		insert("--..","z"); insert("--.-","q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> LNR = new ArrayList<String>();
		LNRoutputTraversal(root, LNR);
		return LNR;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root.getLeft() != null) {
			LNRoutputTraversal(root.getLeft(), list);
		}

		list.add(root.getData());

		if (root.getRight() != null) {
			LNRoutputTraversal(root.getRight(), list);
		}

		return;
	}

}
