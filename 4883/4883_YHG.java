import java.io.*;
import java.util.StringTokenizer;

public class Problem_4883 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int caseNum = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			int[][] insert = new int[N][3];
			int[][] dp = new int[N][3];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < 3 ; j++)
					insert[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][0] = 1000000;
			dp[0][1] = insert[0][1];
			dp[0][2] = dp[0][1] + insert[0][2];
			
			for(int i = 1; i < N ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(j == 0)
						dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + insert[i][j];
					else if(j == 2) {
						dp[i][j] = dp[i][j-1] + insert[i][j];
						dp[i][j] = Math.min(dp[i-1][j]+ insert[i][j], dp[i][j]);
						dp[i][j] = Math.min(dp[i-1][j-1]+ insert[i][j], dp[i][j]);
					}
					else {
						dp[i][j] = dp[i][j-1] + insert[i][j];
						dp[i][j] = Math.min(dp[i-1][j]+ insert[i][j], dp[i][j]);
						dp[i][j] = Math.min(dp[i-1][j-1]+ insert[i][j], dp[i][j]);
						dp[i][j] = Math.min(dp[i-1][j+1]+ insert[i][j], dp[i][j]);
					}
				}
			}
			System.out.println(caseNum++ + ". " + dp[N-1][1]);
		}
	}
}