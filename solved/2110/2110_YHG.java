import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] home = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			home[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(home);
		
		int min = 1;
		int max = home[N-1] - home[0];
		int len = 0;
		int result = 0;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int start = home[0];
			int sh = 1;
			for(int i = 1 ; i < N ; i++) {
				len = home[i] - start;
				if(mid <= len) {
					sh++;
					start = home[i];
				}
			}
			
			if(sh >= C) {
				result = mid;
				min = mid + 1;
			}
			else
				max = mid - 1;
		}
		System.out.println(result);
	}
}