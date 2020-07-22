import java.util.Scanner;

public class Problem_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 수열의 크기
		int[] arr = new int[N+1];
		int[][] dp = new int[N+1][2]; // 0 : max , 1 : min
		int count = 0;
		
		for(int i = 1 ; i <= N ; i++)
			arr[i] = scn.nextInt();
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j < i ; j++) {
				if(arr[i] > arr[j]) 
					dp[i][0] = Math.max(dp[i][0], dp[j][0]);
				else if(arr[i] < arr[j]) 
					dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][1]));
			}
			
			dp[i][0]++;
			dp[i][1]++;
			
			count = Math.max(count, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(count);
	}
}