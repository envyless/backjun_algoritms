import java.util.Scanner;

public class Problem_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = scn.nextInt(); // 한 줄에 있는 스티커 갯수
			int[][] insert = new int[2][N+1];
			
			for(int i = 0 ; i < 2 ; i++) 
				for(int j = 0 ; j < N ; j++)
					insert[i][j] = scn.nextInt();
			
			int[][] dp = new int[3][N+1];
			
			dp[0][0] = insert[0][0];
			dp[1][0] = insert[1][0];
			dp[2][0] = 0;
			
			for(int i = 1 ; i < N ; i++) {
				
				dp[0][i] = Math.max(dp[1][i-1] , dp[2][i-1]) + insert[0][i];
				dp[1][i] = Math.max(dp[0][i-1] , dp[2][i-1]) + insert[1][i];
				dp[2][i] = Math.max(dp[2][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
			}
			
			int max = Math.max(dp[0][N-1], Math.max(dp[1][N-1], dp[2][N-2]));
			
			System.out.println(max);
		}
	}

}
