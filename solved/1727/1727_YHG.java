import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1727 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N == M) {
			int sum1 = 0, sum2 = 0;
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < N ; i++)
				sum1 += Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < M ; i++)
				sum2 += Integer.parseInt(st.nextToken());
			
			System.out.println(Math.abs(sum1 - sum2));
			return;
		}
		
		int[] first = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= N ; i++)
			first[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(first);
		
		int[] second = new int[M+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= M ; i++)
			second[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(second);
		
		int[][] dp = new int[N+1][M+1];
		int max = 987654321;
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= M ; j++)
				dp[i][j] = max;
		
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= M ; j++) {
				dp[i][j] = Math.min(dp[i-1][j-1] + Math.abs(first[i] - second[j]), dp[i][j]);
				if(i > j)
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				if(i < j)
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
			}
		
		System.out.println(dp[N][M]);
	}
}