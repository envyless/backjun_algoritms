import java.util.Scanner;

public class Problem_2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int[] dp = new int[n+1];
		
		if(n == 1) {
			System.out.println(0);
			return ;
		}
		
		dp[0] = 1;
		
		for(int i = 2 ; i <= n ; i += 2) {
			dp[i] += dp[i-2]*3;
			for(int j = 4; j <= i ; j += 2)
				dp[i] += dp[i-j]*2;
		}	
		System.out.println(dp[n]);
	}
}