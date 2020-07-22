import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2399 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] insert = new long[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(insert);
		long sum = 0;
		
		for(int i = 0 ; i < N ; i++)
			sum += insert[i] * (2*i - 2*(N-i-1));
		
		System.out.println(sum);
	}
}