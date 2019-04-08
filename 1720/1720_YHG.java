import java.io.*;

public class Problem_1720 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		long result = 0;
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2 ; i <= N ; i++)
			dp[i] = (dp[i-2]*2) + dp[i-1];
		
		if(N % 2 == 0) // Â¦¼ö
			result = (dp[N] + dp[N/2] + (dp[(N-2)/2] * 2))/2;
		else
			result = (dp[N] + dp[(N-1)/2])/2;
		
		System.out.println(result);
	}
}