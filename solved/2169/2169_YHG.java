import java.util.Scanner;

public class Problem_2169 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		int[][] insert = new int[N][M];

		int[][] dp = new int[N][M];

		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++)
				insert[i][j] = scn.nextInt();
		
		if(N == 1  || M == 1) {
			int sum = 0;
			if(N == 1) 
				for(int i = 0 ; i < M ; i++)
					sum += insert[0][i];
			else 
				for(int i = 0 ; i < N ; i++)
					sum += insert[i][0];
			
			System.out.println(sum);
			
		}
		else {
			dp[0][0] = insert[0][0];
			
			// 첫 줄은 단방향. 오른쪽으로 이동.
			for(int i = 1 ; i < M ; i++)
				dp[0][i] = insert[0][i] + dp[0][i-1];
			
			int[][] tmp = new int[2][M];
			
			// 마지막 줄 전 까지 연산
			for(int i = 1; i < N ; i++) {
				// 다음 열의 첫 번째. y,0
				tmp[0][0] = insert[i][0] + dp[i-1][0];
				// 다음 열의 마지막. y,M-1
				tmp[1][M-1] = insert[i][M-1] + dp[i-1][M-1];
				
				for(int j = 1; j < M ; j++) 
					tmp[0][j] = Math.max(dp[i-1][j] , tmp[0][j-1]) + insert[i][j];
				
				for(int j = M-2 ; j >= 0 ; j--)
					tmp[1][j] = Math.max(dp[i-1][j], tmp[1][j+1]) + insert[i][j];
				
				for(int j = 0 ; j < M ; j++) 
					dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
			}
			
			System.out.println(dp[N-1][M-1]);
		}
	}
}