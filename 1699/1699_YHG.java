import java.util.Scanner;

public class Problem_1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ÀÚ¿¬¼ö
		int[] dp = new int[100001];
		
		
		for(int i = 1 ; i <= 316 ; i++)
			dp[i*i] = 1;
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2 ; i < 100001 ; i++) {
			int sqrt = (int)Math.sqrt(i);
			int min = N+1;
			
			for(int j = sqrt ; j >= 1 ; j--) {
				int save = 1 + dp[i - (j*j)];
				if( min > save ) {
					min = save;
					dp[i] = min;
				}
			}
		}
		System.out.println(dp[N]);
	}
}