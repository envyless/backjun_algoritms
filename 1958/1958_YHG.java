import java.io.*;

public class Problem_1958 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String first = br.readLine();
		String second = br.readLine();
		String third = br.readLine();
		
		int lenF = first.length();
		int lenS = second.length();
		int lenT = third.length();
		
		int index = Math.max(lenF, Math.max(lenS, lenT)) + 1;
		int[][][] dp = new int[index][index][index];
		
		for(int i = 1 ; i <= lenF ; i++)
			for(int j = 1 ; j <= lenS ; j++)
				for(int k = 1 ; k <= lenT ; k++)
					if(first.charAt(i-1) == second.charAt(j-1) && second.charAt(j-1) == third.charAt(k-1))
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					else
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
		
		System.out.println(dp[lenF][lenS][lenT]);
	}
}