import java.io.*;
import java.util.StringTokenizer;

public class Problem_1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		long sum = 0;
		int start = 0;
		int end = 0;
		int len = 100000;
		int[] insert = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int tmp = 0;
		while(start <= end) {
			if(sum >= S) {
				if(start >= N)
					break;
				sum -= insert[start];
				tmp = end - start;
				if(len > tmp)
					len = tmp;
				start++;
			}
			else {
				if(end >= N)
					break;
				sum += insert[end];
				end++;
			}
		}
		
		if(len == 100000)
			len = 0;
		System.out.println(len);
	}
}