import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11399 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(insert);
		
		int minS = 0;
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			minS = minS + insert[i];
			sum += minS;
		}
		System.out.println(sum);
	}
}