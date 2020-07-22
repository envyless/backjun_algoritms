import java.io.*;
import java.util.StringTokenizer;

public class Problem_3985 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		boolean[] roll = new boolean[L+1];
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		
		int maxL = 0;
		int maxN = 0;
		int start, end, tmp;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			tmp = end - start;
			if(maxL < tmp) {
				maxL = tmp;
				maxN = i;
			}
			for(int j = start ; j <= end ; j++) {
				if(!roll[j]) {
					roll[j] = true;
					insert[i]++;
				}
			}
		}
		System.out.println(maxN+1);
	
		maxL = 0;
		for(int i = 0 ; i < N ; i++)
			if(maxL < insert[i]) {
				maxL = insert[i];
				maxN = i;
			}	
		System.out.println(maxN+1);
	}
}