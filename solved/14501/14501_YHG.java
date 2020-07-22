import java.util.Scanner;

public class Problem_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 남은 상담 일수
		int[][] insert = new int[N+1][2];
		
		for(int i = 0 ; i < N ; i++) {
			insert[i][0] = scn.nextInt();
			insert[i][1] = scn.nextInt();
		}
		
		int[] dp = new int[N+1];
		int max = 0;
		
		for(int i = N -1 ; i >= 0 ; i--) {
			if(dp[i] == 0) dp[i] = dp[i+1];
			
			if(i + insert[i][0] > N) continue;
			
			dp[i] = Math.max(dp[i+insert[i][0]] + insert[i][1], dp[i]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}
