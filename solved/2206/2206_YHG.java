import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_2206 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // За
		int M = Integer.parseInt(st.nextToken()); // ї­
		int count = -1;
		int[][] insert = new int[N][M];
		boolean[][][] visit = new boolean[N][M][2];
		Queue<point_2206> q = new LinkedList<point_2206>();
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = tmp.charAt(j) - 48;
		}
		
		q.add(new point_2206(0,0,false,0));
		
		while(!q.isEmpty()) {
			point_2206 now = q.poll();
			int nowX = now.x; // M
			int nowY = now.y; // N
			boolean nowB = now.broken;
			int index;
			if(nowB)
				index = 1;
			else
				index = 0;
			
			visit[nowY][nowX][index] = true;
			
			if(nowX == M-1 && nowY == N-1) {
				if(count <= now.count)
					count = now.count;
				break;
			}
			
			int[] moveX = {-1, 1, 0, 0};
			int[] moveY = {0, 0, -1, 1};
			
			for(int i = 0 ; i < 4 ; i++) {
				int nextX = nowX + moveX[i];
				int nextY = nowY + moveY[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !visit[nextY][nextX][index]) {
					if(insert[nextY][nextX] == 0) {
						visit[nextY][nextX][index] = true;
						q.add(new point_2206(nextY, nextX, nowB, now.count+1));
					}
					
					if(insert[nextY][nextX] == 1)
						if(!nowB) {
							visit[nextY][nextX][1] = true;
							q.add(new point_2206(nextY, nextX, true, now.count+1));
						}
				}
			}
		}
		if(count == -1)
			System.out.println(count);
		else
			System.out.println(count+1);
	}
}
class point_2206{
	int x;
	int y;
	boolean broken;
	int count;
	
	public point_2206(int y, int x, boolean broken, int count) {
		this.x = x;
		this.y = y;
		this.broken = broken;
		this.count = count;
	}
}