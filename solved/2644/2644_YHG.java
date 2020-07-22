import java.io.*;
import java.util.StringTokenizer;

public class Problem_2644 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 사람 수
		int[][] count = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= N ; j++)
				count[i][j] = 1000;
		
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // 알고 싶은 관계
		
		int M = Integer.parseInt(br.readLine()); // 관계 수
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			count[x][y] = 1;
			count[y][x] = 1;
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
		
		if(count[a][b] == 1000)
			count[a][b] = -1;
		System.out.println(count[a][b]);
	}
}