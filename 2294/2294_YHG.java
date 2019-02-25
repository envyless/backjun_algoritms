import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2294 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int[] dp = new int[10001];
		
		int MAX = 987654321;
		for(int i = 0 ; i <= K ; i++)
			dp[i] = MAX;
		
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			coin[i] = tmp;
			if(tmp <= K)
				dp[tmp] = 1;
		}
		
		for(int i = 0 ; i < N ; i++) 
			for(int j = coin[i] ; j <= K ; j++) {
				if(j % coin[i] == 0) 
					dp[j] = Math.min(dp[j], j / coin[i]);
				if(dp[j - coin[i]] != MAX)
					dp[j] = Math.min(dp[j], dp[coin[i]] + dp[j - coin[i]]);
			}
		
		if(dp[K] == MAX)
			System.out.println(-1);
		else
			System.out.println(dp[K]);
	}
}