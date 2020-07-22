import java.util.Scanner;

public class Problem_2225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int mod = 1000000000;
		
		int N = scn.nextInt(); // 자연수 범위
		int K = scn.nextInt(); // 사용할 갯수
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 0 ; i <= K ; i++)
			dp[0][i] = 1;
		
		for(int i = 1; i <= N ; i++)
			for(int j = 1 ; j <= K ; j++)
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
		
		System.out.println(dp[N][K]);
	}
}