package com.bluecloudes.algo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for All Algorithms.
 */
public class TestAll 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestAll( String testName )
    {
    	
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        TestSuite testSuit = new TestSuite( LongestIncresingSequenceTest.class );
        testSuit.addTestSuite(ChangeMakingProblemTest.class);
        return testSuit;
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
