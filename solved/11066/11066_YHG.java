import java.io.*;
import java.util.StringTokenizer;

public class Problem_11066 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;	
		
		int T = Integer.parseInt(br.readLine());
		int MAX = 987654321;
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine());
			int[] sum = new int[N+1];
			int[][] dp = new int[N+1][N+1];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 1 ; i <= N ; i++)
				sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
			
			for(int k = 1 ; k < N ; k++)
				for(int i = 1 ; i <= N-k ; i++) {
					dp[i][i+k] = MAX;
					for(int j = i ; j < i+k ; j++)
						dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k]);
					dp[i][i+k] += sum[i+k] - sum[i-1];
				}
			
			System.out.println(dp[1][N]);
		}
	}
}