import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_3047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// A < B < C
		int[] insert = new int[3];
		char[] sort = new char[3];
		for(int i = 0 ; i < 3 ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(insert);
		
		String tmp = br.readLine();
		for(int i = 0 ; i < 3 ; i++)
			System.out.print(insert[tmp.charAt(i) - 'A'] + " ");
	}
}