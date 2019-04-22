import java.io.*;
import java.util.StringTokenizer;

public class Problem_1238 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		int X = Integer.parseInt(st.nextToken()); // 도착지
		
		int[][] map = new int[N+1][N+1]; // index 0은 사용하지 않음.
		int INF = 10000000;
		for(int i = 0 ; i <= N ; i++)
			for(int j = 0 ; j <= N ; j++)
				map[i][j] = INF;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int k = 1 ; k <= N ; k++)
			for(int i = 1 ; i <= N ; i++)
				for(int j = 1 ; j <= N ; j++) {
					if(i == j)
						continue;
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
		
		int max = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(i == X)
				continue;
			if(max < map[i][X] + map[X][i])
				max = map[i][X] + map[X][i];
		}
		System.out.println(max);
	}
}