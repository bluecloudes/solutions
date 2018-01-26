import java.util.Arrays;


public class EggDropProblem {
	public static int count(int eggs, int floors) {
		int[][] T = new int[eggs+1][floors+1];
		
		for(int i=1; i<=eggs;i++) {
			T[i][0] = 0;
			T[i][1] = 1;
		}
		
		for(int i=1; i<=floors;i++){
			T[1][i] = i;
		}
		
		for(int i=2;i<=eggs;i++) {
			for(int j=2;j<=floors;j++) {
				
				if(i>j) {
					T[i][j]=T[i-1][j];
				} else {
					int tValue = Integer.MAX_VALUE;
					for(int k=1;k<=j;k++) {
						tValue = Math.min(tValue, 1+ Math.max(T[i-1][k-1],T[i][j-k]));
					}
					T[i][j]=tValue;
				}
				
			}
		}
		for(int i=0;i<T.length;i++) {
			System.out.println(Arrays.toString(T[i]));
		}
		return T[eggs][floors];
	}
	public static void main(String[] args){
		System.out.println(count(2, 36));
	}
}
