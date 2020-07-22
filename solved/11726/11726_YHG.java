import java.util.Scanner;

public class Problem_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // 2xN ±Ê¿Ã.
		int[] dp = new int[n+1];
		int MOD = 10007;
		
		if(n == 1) {
			System.out.println(1);
			return ;
		}
		if(n == 2) {
			System.out.println(2);
			return ;
		}
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3 ; i <= n ; i++)
			dp[i] += (dp[i-1] + dp[i-2]) % MOD;
		System.out.println(dp[n]);
	}
}