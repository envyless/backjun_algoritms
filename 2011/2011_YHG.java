import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		int len = insert.length();
		int[] dp = new int[len+1];
		char[] num = new char[len+1];
		int MOD = 1000000;
		
		for(int i = 1 ; i <= len ; i++)
			num[i] = insert.charAt(i-1);
		dp[0] = 1;
		dp[1] = 1;
		
		if(num[1] - '0' == 0) {
			System.out.println(0);
			return;
		}
		
		int tmp = 0;
		for(int i = 2; i <= len ; i++) {
			dp[i] = dp[i-1] % MOD;
			if(num[i] - '0' == 0) {
				dp[i] = dp[i-2] % MOD;
				if(num[i-1] - '0' > 2) {
					dp[i] = 0;
					break;
				}
				if(i+1 <= len) {
					dp[i+1] = dp[i];
					i++;
				}
				continue;
			}
			tmp = (num[i-1] - '0') * 10 + (num[i] - '0');
			if(tmp >= 1 && tmp <= 26)
				dp[i] = (dp[i] + dp[i-2]) % MOD;
		}
		System.out.println(dp[len]);
	}
}