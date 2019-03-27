import java.io.*;
import java.util.StringTokenizer;

public class Problem_2229 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dif = new int[N+1][N+1];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		int[] insert = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int max,min;
		for(int i = 1 ; i <= N ; i++) {
			max = -1;
			min = 50000;
			for(int j = i ; j <= N ; j++) {
				if(min > insert[j]) min = insert[j];
				if(max < insert[j]) max = insert[j];
				dif[i][j] = max - min;
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j < i ; j++)
				if(dp[i] < dp[j] + dif[j+1][i])
					dp[i] = dp[j] + dif[j+1][i];
			if(dp[i] < dif[1][i])
				dp[i] = dif[1][i];
		}
		System.out.println(dp[N]);
	}
}