import java.io.*;
import java.util.StringTokenizer;

public class Problem_1389 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken()); // 유저 수
		int M = Integer.parseInt(st.nextToken()); // 관계 수
		
		int[][] count = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= N ; j++)
				count[i][j] = 1000;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			count[a][b] = 1;
			count[b][a] = 1;
		}
		
		for(int k = 1 ; k <= N ; k++) {
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(i == j)
						continue;
					if(count[i][j] > count[i][k] + count[k][j])
						count[i][j] = count[i][k] + count[k][j];
				}
			}
		}
		
		int[] result = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ;  j <= N ; j++) {
				if(i == j)
					continue;
				result[i] += count[i][j];
			}
		}
		
		int min = 1000;
		int index = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(min > result[i]) {
				index = i;
				min = result[i];
			}
		}
		System.out.println(index);
	}
}