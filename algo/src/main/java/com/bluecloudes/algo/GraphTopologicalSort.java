package com.bluecloudes.algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTopologicalSort {
	int V;
	
	LinkedList<Integer>[] adj;
	public GraphTopologicalSort(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		this.stack = new Stack<Integer>();
	}
	
	

	public static void main(String args[])
    {
		GraphTopologicalSort g = new GraphTopologicalSort(6);
 
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
 
        g.topological();
    }



	private void topological() {
		boolean[] visited = new boolean[V];
		for (int j = 0; j < visited.length; j++) {
			visited[j] = false;
		}
		for (int j = 0; j < V; j++) {
			if(visited[j] == false)
				topologicalSort(j, visited);
		}
		
		System.out.println("Sort order");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}



	private void topologicalSort(int i, boolean[] visited) {
		if(visited[i] == true) {
			return;
		}
		
		visited[i] = true;
		
		LinkedList<Integer> list = adj[i];
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer node = (Integer) iterator.next();
			topologicalSort(node, visited);
		}
		stack.push(i);
		
	}
	
	private Stack<Integer> stack;



	private void addEdge(int i, int j) {
		adj[i].add(j);		
	}
}
