import java.util.Scanner;

public class Problem_11057 {
	
	static int mod = 10007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 길이
		
		int[] dp = new int[10];
		int result = 0;
		
		for (int i = 0; i < 10; i++) 
			dp[i] = 1;
		
		// N이 1일 때는 별다른 연산이 필요하지 않음.
		if(N == 1)
			System.out.println(10);
		else {
			
			for (int i = 1; i < N; i++) {
				result = 0;
				
				for (int j = 1; j < 10; j++) {
					dp[j] = (dp[j] + dp[j - 1]) % mod;
					result = (result + dp[j]) % mod;
				}
			}
			result++; // N자리의 모든 수가 0일 경우도 있음.
			System.out.println(result % mod);
		}
	}
}