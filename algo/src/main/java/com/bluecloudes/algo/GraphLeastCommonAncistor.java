package com.bluecloudes.algo;

import com.bluecloudes.algo.holders.Node;

public class GraphLeastCommonAncistor {
	Node root;
	 /* Driver program to test above functions */
    public static void main(String args[])
    {
    	GraphLeastCommonAncistor tree = new GraphLeastCommonAncistor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                            tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                            tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                            tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                            tree.findLCA(2, 4).data);
    }
    
	private Node findLCA(int i, int j) {
		return findLCA(root, i, j);
	}
	
	
	private Node findLCA(Node node, int i, int j) {
		if(node == null) {
			return null;
		}
		if(node.data == i || node.data == j) {
			return node;
		}
		Node left = findLCA(node.left, i, j);
		Node right = findLCA(node.right, i, j);
		
		if(left != null && right != null) {
			return node;
		}
		if(left !=null) {
			return left;
		} else {
			return left;
		}
		
	}
	
}























