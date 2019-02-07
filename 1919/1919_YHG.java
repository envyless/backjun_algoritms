import java.io.*;

public class Problem_1919 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int[][] alpha = new int[2][26];
		String in;
		
		for(int i = 0 ; i < 2 ; i++) {
			in = br.readLine();
			for(int j = 0 ; j < in.length() ; j++)
				alpha[i][in.charAt(j) - 'a']++;
		}
		
		int result = 0;
		for(int i = 0 ; i < 26 ; i++)
			result += Math.abs(alpha[0][i] - alpha[1][i]);
		
		System.out.println(result);
	}
}