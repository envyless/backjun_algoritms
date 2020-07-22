import java.io.*;
import java.util.StringTokenizer;

public class Problem_2455 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int[][] insert = new int[4][2];
		int[] sum = new int[4];
		int max = 0;
		for(int i = 0 ; i < 4 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			insert[i][0] = Integer.parseInt(st.nextToken());
			insert[i][1] = Integer.parseInt(st.nextToken());
			if(i == 0)
				sum[i] = insert[i][1];
			else
				sum[i] = sum[i-1] + insert[i][1] - insert[i][0];
			if(max < sum[i])
				max = sum[i];
		}
		System.out.println(max);
	}
}