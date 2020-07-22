import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1952 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken()); // 세로
		int N = Integer.parseInt(st.nextToken()); // 가로
		
		boolean[][] visit = new boolean[M][N];
		Queue<point_1952> q = new LinkedList<point_1952>();
		visit[0][0] = true;
		q.add(new point_1952(0,0,0));
		
		int[] moveX = {1,0,-1,0};
		int[] moveY = {0,1,0,-1};
		int index = 0;
		int count = 0;
		while(!q.isEmpty()) {
			point_1952 now = q.poll();
			int x = now.x;
			int y = now.y;
			if(now.c > 4) {
				count -= now.c;
				break;
			}
			
			int nextX = x + moveX[index];
			int nextY = y + moveY[index];
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visit[nextY][nextX]) {
				visit[nextY][nextX] = true;
				q.add(new point_1952(nextY,nextX,0));
			}
			else {
				index++;
				count++;
				if(index == 4)
					index = 0;
				q.add(new point_1952(y,x,now.c+1));
			}
		}
		System.out.println(count);
	}
}
class point_1952{
	int x;
	int y;
	int c;
	
	public point_1952(int y, int x, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}