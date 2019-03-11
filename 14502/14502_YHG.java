import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_14502 {

	static int N;
	static int M;
	static Queue<point_14502> q;
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };
	static int max = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<point_14502>();
		int[][] map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					q.add(new point_14502(j,i));
			}
		}
		dfs(map,0);
		System.out.println(max);
	}
	
	static public void dfs(int[][] map, int door) {
		if(door == 3) {
			Queue<point_14502> tmpq = new LinkedList<point_14502>();
			Queue<point_14502> saveq = new LinkedList<point_14502>();
			while(!q.isEmpty()) {
				point_14502 now = q.poll();
				tmpq.add(new point_14502(now.x, now.y));
				saveq.add(new point_14502(now.x, now.y));
			}
			while(!tmpq.isEmpty()) {
				point_14502 now = tmpq.poll();
				int x = now.x;
				int y = now.y;
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = x + moveX[i];
					int nextY = y + moveY[i];
					
					if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] != 0)
						continue;
					
					map[nextY][nextX] = 3;
					tmpq.add(new point_14502(nextX,nextY));
				}
			}
			int count = 0;
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < M ; j++)
					if(map[i][j] == 0)
						count++;
			if(max < count)
				max = count;
			
			while(!saveq.isEmpty()) {
				point_14502 now = saveq.poll();
				q.add(new point_14502(now.x, now.y));
			}
			return;
		}
		else {
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < M ; j++)
					if(map[i][j] == 0) {
						map[i][j] = 1;
						dfs(map,door + 1);
						map[i][j] = 0;
						for(int ii = 0 ; ii < N ; ii++)
							for(int jj = 0 ; jj < M ; jj++)
								if(map[ii][jj] == 3)
									map[ii][jj] = 0;
					}
		}
	}
}
class point_14502{
	int x;
	int y;
	
	public point_14502(int x, int y) {
		this.x = x;
		this.y = y;
	}
}