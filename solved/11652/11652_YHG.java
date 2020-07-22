import java.util.Arrays;
import java.io.*;

public class Problem_11652 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		int N = Integer.parseInt(br.readLine()); // 정점의 수
		long[] insert = new long[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(insert);
		
		long max = insert[0];
		int count = 0;
		int maxCount = 0;
		
		for(int i = 0 ; i < N-1 ; i++) {
			if(insert[i] == insert[i+1])
				count++;
			else
				count = 0;
			
			if(maxCount < count) {
				maxCount = count;
				max = insert[i];
			}
		}
		System.out.println(max);
	}
}