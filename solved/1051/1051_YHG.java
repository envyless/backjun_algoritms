import java.io.*;
import java.util.StringTokenizer;

public class Problem_1051 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] insert = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = tmp.charAt(j) - '0';
		}
		
		int start = Math.min(N, M);
		
		for(int i = start ; i >= 0 ; i--) {
			for(int j = 0 ; j <= N-i ; j++)
				for(int k = 0 ; k <= M-i ; k++)
					if(insert[j][k] == insert[j][k+i-1] && insert[j][k] == insert[j+i-1][k] && insert[j][k] == insert[j+i-1][k+i-1]) {
						System.out.println(i*i);
						return;
					}
		}
	}
}