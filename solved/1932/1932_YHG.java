import java.util.Scanner;

public class Problem_1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // 삼각형의 크기
		int[][] insert = new int[n][];
		int[][] dp = new int [n][];
		
		for(int i = 0 ; i < n ; i++) {
			insert[i] = new int[i+1];
			dp[i] = new int[i+1];
		}
		
		for(int i = 0 ; i < n ; i++)
			for(int j = 0 ; j <= i ; j++) 
				insert[i][j] = scn.nextInt();

		dp[0][0] += insert[0][0];
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0)
					dp[i][j] = insert[i][j] + dp[i-1][j];
				else if(j == i)
					dp[i][j] = insert[i][j] + dp[i-1][j-1];
				else
					dp[i][j] = insert[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}

		int max = 0;
		for(int i = 0 ; i < n ; i++) {
			int tmp = dp[n-1][i];
			if(max < tmp)
				max = tmp;
		}
		System.out.println(max);
	}
}