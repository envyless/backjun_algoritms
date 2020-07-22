import java.util.Scanner;

public class Problem_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int n = scn.nextInt();
			int[] dp = new int[n+1];
			
			dp[0] = 1;
			
			for(int i = 1 ; i <= n ; i++) {
				if(i >= 1) 
					dp[i] += dp[i-1];
				if(i >= 2)
					dp[i] += dp[i-2];
				if(i >= 3)
					dp[i] += dp[i-3];
			}
			System.out.println(dp[n]);			
		}
	}
}