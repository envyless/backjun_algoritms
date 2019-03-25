import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1940 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(insert);
		
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = N-1 ; j > i ; j--) {
				if(insert[i] == -1 || insert[j] == -1)
					continue;
				if(insert[i] + insert[j] == M) {
					count++;
					insert[i] = -1;
					insert[j] = -1;
					break;
				}
			}
		}
		System.out.println(count);
	}
}