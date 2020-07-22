import java.util.Scanner;

public class Problem_11051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 1 ~ 1000
		int K = scn.nextInt(); // 0 ~ N
		// N! / K ! ( N - K ) !
		int mod = 10007;
		
		int[][] dp = new int[1001][1001];
		dp[0][0] = 1; 
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i = 2; i <= N; i++){
			for(int j = 0; j <= i; j++){
				if((i == j) || (j == 0))
					dp[i][j] = 1;
				else
					dp[i][j] = (dp[i-1][j] % mod + dp[i-1][j-1] % mod) % mod;
			}
		}
		System.out.println(dp[N][K]);
	}
}