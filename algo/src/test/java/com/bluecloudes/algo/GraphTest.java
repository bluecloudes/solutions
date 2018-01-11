package com.bluecloudes.algo;

import junit.framework.TestCase;

public class GraphTest   extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	Graph graph;
	
	
    public GraphTest( String testName )
    {
    	
        super( testName );
        Graph g = new Graph(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
    	graph.DFS(2);
        
    }
}
