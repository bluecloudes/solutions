package com.bluecloudes.algo;

import junit.framework.TestCase;

public class MinimumPlatformCountTest   extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	MinimumPlatformCount problem;

	
    public MinimumPlatformCountTest( String testName )
    {
    	
        super( testName );
        problem = new MinimumPlatformCount();
    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        assertTrue( problem.findPlatform(arr, dep) == 3 );
    }
}
