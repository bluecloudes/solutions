package com.bluecloudes.algo;

import junit.framework.TestCase;

public class CoinChangeCountWaysTest   extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	CoinChangeCountWays changeMakingProblem;
	int[] coins =  {1, 2, 5};
	int amount = 5;
	
    public CoinChangeCountWaysTest( String testName )
    {
    	
        super( testName );
        changeMakingProblem = new CoinChangeCountWays();
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( changeMakingProblem.byRecursion(coins, amount) == 4 );
        assertTrue( changeMakingProblem.byDynamicProgramming(coins, amount) == 4 );
    }
}
