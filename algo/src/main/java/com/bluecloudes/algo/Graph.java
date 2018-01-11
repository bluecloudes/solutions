package com.bluecloudes.algo;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int v,int u) {
		adj[v].add(u);
	}
	
	public void DFS(int start) {
		boolean visited[] = new boolean[V];
		DFSUtil(start, visited);
	}
	private void DFSUtil(int start, boolean[] visited) {
		visited[start] = true;
		System.out.print(start + " ");
		
		LinkedList<Integer> neighbours = adj[start];
		neighbours.stream().forEach(neighbour -> {
			if(visited[neighbour]==false) {
				DFSUtil(neighbour, visited);
			}
		});
		
	}
	
	public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
    }
	
}
