package com.bluecloudes.algo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for all Algo.
 */
public class LongestIncresingSequenceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	LongestIncresingSequence longestIncresingSequence;
	int[] input =  {10, 22, 9, 33, 21, 50, 41, 60, 80};
	
    public LongestIncresingSequenceTest( String testName )
    {
    	
        super( testName );
        longestIncresingSequence = new LongestIncresingSequence();
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( longestIncresingSequence.lengthByDynamicProgramming(input) == 6 );
        assertTrue( longestIncresingSequence.length(input) == 6 );
    }
}
