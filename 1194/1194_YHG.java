import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1194 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+10][M+10];
		int[][][] visit = new int[N+10][M+10][1 << 7];
		Queue<point_1194> q = new LinkedList<point_1194>();
		
		String tmp;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = tmp.charAt(j);
				if(tmp.charAt(j) == '0')
					q.add(new point_1194(j,i,0));
			}
		}
		
		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };
		int min = 987654321;
		while(!q.isEmpty()) {
			point_1194 now = q.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowK = now.k;
			
			if(map[nowY][nowX] == '1') {
				if(min > visit[nowY][nowX][nowK])
					min = visit[nowY][nowX][nowK];
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = nowX + moveX[i];
				int nextY = nowY + moveY[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == '#' || visit[nextY][nextX][nowK] > 0)
					continue;
				
				if(map[nextY][nextX] >= 'a' && map[nextY][nextX] <= 'f') {
					int nextK =  nowK | (1 << map[nextY][nextX] - 'a');
					if(visit[nextY][nextX][nextK] == 0) {
						visit[nextY][nextX][nextK] = visit[nowY][nowX][nowK] + 1;
						q.add(new point_1194(nextX, nextY, nextK));
					}
				}
				else if(map[nextY][nextX] >= 'A' && map[nextY][nextX] <= 'F') {
					int nextK = 1 << map[nextY][nextX] - 'A';
					if((nextK & nowK) == nextK) {
						visit[nextY][nextX][nowK] = visit[nowY][nowX][nowK] + 1;
						q.add(new point_1194(nextX, nextY, nowK));
					}
				}
				else {
					visit[nextY][nextX][nowK] = visit[nowY][nowX][nowK] + 1;
					q.add(new point_1194(nextX, nextY, nowK));
				}
			}
		}
		
		if(min == 987654321)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
class point_1194{
	int x;
	int y;
	int k;
	
	public point_1194(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}