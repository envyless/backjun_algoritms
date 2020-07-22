import java.util.Scanner;

public class Problem_11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // ±æÀÌ
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		if(n > 1) dp[2] = 3;
		
		for(int i = 3; i <= n ; i++) 
			dp[i] = ((dp[i-2] * 2) + dp[i-1])%10007;	
		System.out.println(dp[n]);
	}
}