import java.util.Scanner;

public class Problem_1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 세로 길이.
		int[][] dp = new int[N][3];
		int mod = 9901;
		
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		
		for(int i = 1 ; i < N ; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}
		
		int result = 0;
		for(int i = 0 ; i < 3 ; i++)
			result += dp[N-1][i];
		
		System.out.println(result % mod);
	}
}