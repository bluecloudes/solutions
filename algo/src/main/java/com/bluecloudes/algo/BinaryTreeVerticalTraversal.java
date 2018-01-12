package com.bluecloudes.algo;

import com.bluecloudes.algo.holders.MinMax;
import com.bluecloudes.algo.holders.Node;

public class BinaryTreeVerticalTraversal {
	
	
	public Node root;
	
	public void hDistance(Node root, MinMax minMax, int hd) {
		if(root == null) {
			return;
		}
		if(minMax.min > hd) {
			minMax.min = hd;
		}
		if(minMax.max < hd) {
			minMax.max = hd;
		}
		hDistance(root.left, minMax, hd-1);
		hDistance(root.right, minMax, hd+1);
	}

	// Driver program to test the above functions
    public static void main(String args[]) 
    {
    	BinaryTreeVerticalTraversal tree = new BinaryTreeVerticalTraversal();
  
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        
        
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
    
    public void printVertialOrder(Node root, int distance, int current) {
    	if(root == null) {
    		return;
    	}
    	
    	if(distance == current) {
    		System.out.print(root.data + " ");
    	}
    	printVertialOrder(root.left, distance, current-1);
    	printVertialOrder(root.right, distance, current+1);
    	
    }

	public void verticalOrder(Node root) {

		MinMax minMax = new MinMax();
        hDistance(root, minMax, 0);
        System.out.println("hDistance : (min, max) ( "+minMax.min+", "+ minMax.max +") ");
        
        for (int i = minMax.min; i <= minMax.max; i++) {
			printVertialOrder(root, i, 0);
		}
	}
}
