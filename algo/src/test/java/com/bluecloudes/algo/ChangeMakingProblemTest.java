package com.bluecloudes.algo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for all Algo.
 */
public class ChangeMakingProblemTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	ChangeMakingProblem changeMakingProblem;
	int[] coins =  {1, 5, 7, 20};
	int amount = 15;
	
    public ChangeMakingProblemTest( String testName )
    {
    	
        super( testName );
        changeMakingProblem = new ChangeMakingProblem();
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( changeMakingProblem.byRecursive(coins, amount) == 3 );
        assertTrue( changeMakingProblem.byDyanamicProgramming(coins, amount) == 3 );
    }
}
