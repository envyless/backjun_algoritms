import java.io.*;
import java.util.StringTokenizer;

public class Problem_1613 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 사건의 수 ~ 400
		int K = Integer.parseInt(st.nextToken()); // 관계의 수 ~ 50,000
		
		int[][] ac = new int[N+1][N+1];
		int max = 1000000;
		
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= N ; j++)
				ac[i][j] = max;
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			ac[start][end] = -1;
			ac[end][start] = 1;
		}
		
		for(int ii = 1 ; ii <= N ; ii++) {
			for(int jj = 1 ; jj <= N ; jj++) {
				if(ac[ii][jj] == max)
					System.out.print(0 + " ");
				else
					System.out.print(ac[ii][jj] + " ");
			}
			System.out.println();
		}
		
		for(int k = 1 ; k <= N ; k++)
			for(int i = 1 ; i <= N ; i++) 
				for(int j = 1 ; j <= N ; j++)
					if(ac[i][k] != max && ac[i][k] == ac[k][j]) {
						System.out.println("now i,j,k ? " + i + " , " + j + " , " + k);
						System.out.println("change.. " + ac[i][j] + " to " + ac[i][k]);
						ac[i][j] = ac[i][k];
						for(int ii = 1 ; ii <= N ; ii++) {
							for(int jj = 1 ; jj <= N ; jj++) {
								if(ac[ii][jj] == max)
									System.out.print(0 + " ");
								else
									System.out.print(ac[ii][jj] + " ");
							}
							System.out.println();
						}
					}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(ac[i][j] == max)
					System.out.print(0 + " ");
				else
					System.out.print(ac[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("********************");
		
		int result = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < result ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(ac[start][end] == max)
				System.out.println(0);
			else
				System.out.println(ac[start][end]);
		}
	}
}