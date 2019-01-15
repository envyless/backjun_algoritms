import java.io.*;

public class Problem_10808 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		int[] alpha = new int[26];
		
		for(int i = 0 ; i < insert.length() ; i++)
			alpha[insert.charAt(i) - 'a']++;
		
		for(int i = 0 ; i < 26 ; i++)
			System.out.print(alpha[i] + " ");
	}
}