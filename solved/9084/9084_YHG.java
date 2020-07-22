import java.io.*;
import java.util.StringTokenizer;

public class Problem_9084 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine());
			int[] insert = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < N ; i++)
				insert[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			
			for(int i = 0 ; i < N ; i++) {
				if(insert[i] > M)
					continue;
				dp[insert[i]]++;
				
				for(int j = insert[i]+1 ; j <= M ; j++)
					dp[j] = dp[j] + dp[j - insert[i]];
			}
			
			System.out.println(dp[M]);
		}
	}
}