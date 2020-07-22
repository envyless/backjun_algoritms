import java.io.*;
import java.util.StringTokenizer;

public class Problem_2616 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1 ; i <= N ; i++)
			insert[i] = insert[i-1] + Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[][] dp = new int[4][N+1];
		
		for(int i = 1 ; i <= 3 ; i++)
			for(int j = i*M ; j <= N ; j++)
				if(i == 1)
					dp[i][j] = Math.max(dp[i][j-1], insert[j] - insert[j-M]);
				else
					dp[i][j] = Math.max(dp[i][j-1], insert[j] - insert[j-M] + dp[i-1][j-M]);
		
		System.out.println(dp[3][N]);
	}
}