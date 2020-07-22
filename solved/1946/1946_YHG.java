import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_1946 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine());
			int[][] insert = new int[N][2];
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				insert[i][0] = Integer.parseInt(st.nextToken());
				insert[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(insert, new Comparator<int []>() {
				public int compare(int[] v1, int[] v2) {
					return v1[0] - v2[0] < 0 ? -1 : 1;
				}
			});
			
			int count = 1;
			int max = insert[0][1];
			for(int i = 1 ; i < N ; i++) {
				if(insert[i][1] < max) {
					count++;
					max = insert[i][1];
				}
			}
			System.out.println(count);
		}
	}
}