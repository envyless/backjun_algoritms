import java.util.Scanner;

public class Problem_11048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 배열의 세로
		int M = scn.nextInt(); // 배열의 가로
		int[][] insert = new int[N][M];
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = scn.nextInt();
		
		int[][] dp = new int[N][M];
		dp[0][0] = insert[0][0];
		
		for(int i = 1 ; i < N ; i++)
			dp[i][0] = dp[i-1][0] + insert[i][0];
		
		for(int j = 1 ; j < M ; j++) 		
			dp[0][j] = dp[0][j-1] + insert[0][j];
		
		for(int i = 1; i < N ; i++)
			for(int j = 1 ; j < M ; j++)
				dp[i][j] = insert[i][j] + Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
		
		System.out.println(dp[N-1][M-1]);
	}
}