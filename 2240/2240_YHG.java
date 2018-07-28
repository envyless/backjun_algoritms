import java.util.Scanner;

public class Problem_2240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 시간 초
		int W = scn.nextInt(); // 이동 횟수
		
		int[] insert = new int[T+1];
		int[][] dp = new int[T+1][W+1];
		int max = 0;
		
		for(int i = 1 ; i < T+1 ; i++) 
			insert[i] = scn.nextInt();	
		
		
		for(int i = 1 ; i < T+1 ; i++) {
			
			for(int j = 0 ; j < W+1 ; j++) {
				
				if(j != 0) {
					if(insert[i] == 1 && j % 2 == 0) 
						dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1]) + 1;
					else if(insert[i] == 2 && j % 2 == 1)
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + 1;
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
				}else {
					if(insert[i] == 1 && j % 2 == 0) 
						dp[i][j] = dp[i-1][j] + 1;
					else if(insert[i] == 2 && j % 2 == 1)
						dp[i][j] = dp[i-1][j] + 1;
					else
						dp[i][j] = dp[i-1][j];
				}		
				max = Math.max(max, dp[i][j]);
			}
		}	
		System.out.println(max);
	}
}