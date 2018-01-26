package com.bluecloudes.algo;

import java.util.Arrays;

public class WeightedJobScheduling {

	public static class Job {
		public int start;
		public int end;
		public int profit;
		public String toString() {
			return "("+start+","+end+","+profit+")";
		}
		public Job(int[] aJob) {
			start= aJob[0];end=aJob[1];profit=aJob[2];
		}
	}
	
	public static void main(String[] args) {
		int[] aJob = {3, 10, 20};
		Job job1 = new Job(aJob);
		aJob = new int[]{1, 2, 50};
		Job job2 = new Job(aJob);
		aJob = new int[]{6,19,100};
		Job job3 = new Job(aJob);
		aJob = new int[]{2,100,200};
		Job job4 = new Job(aJob);
		Job jobs[] = {job1, job2, job3, job4};
	    System.out.println(findMaxProfit(jobs));
	}

	private static int findMaxProfit(Job[] jobs) {
		
		Arrays.sort(jobs, (job1, job2)-> (job1.end - job2.end));
		for(Job job:jobs){
			System.out.println(job.toString());
		}
		int profit[] = new int[jobs.length];
		profit[0] = jobs[0].profit;
		for(int i=1; i<jobs.length; i++) {
			int excludeI = profit[i-1];
			int nonOverlapping = findNonOverlap(jobs, i);
			int includeI = jobs[i].profit;
			if(nonOverlapping != -1) {
				includeI += jobs[nonOverlapping].profit;
			}
			profit[i] = Math.max(excludeI, includeI);
		}
		return profit[profit.length-1];
	}

	private static int findNonOverlap(Job[] jobs, int i) {
		for (int j = i-1; j >= 0; j--) {
			if(jobs[j].end <= jobs[i].start) {
				return j;
			}
		}
		return -1;
	}
}
