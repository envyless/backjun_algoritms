import java.io.*;
import java.util.StringTokenizer;

public class Problem_2003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		
		while(start <= end) {
			if(sum >= M) {
				if(start >= N)
					break;
				if(sum == M)
					count++;
				sum -= insert[start];
				start++;
			}
			else {
				if(end >= N)
					break;
				sum += insert[end];
				end++;
			}
		}
		System.out.println(count);
	}
}