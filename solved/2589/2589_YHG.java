import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_2589 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		String tmp;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
				if(tmp.charAt(j) == 'L')
					map[i][j] = true;
		}
		
		Queue<point_2589> q = new LinkedList<point_2589>();
		boolean[][] check = new boolean[N][M];
		int[] moveX = { -1, 1, 0, 0 };
		int[] moveY = { 0, 0, -1, 1 };
		int max = 0;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(!map[i][j])
					continue;
				
				q.add(new point_2589(j,i,0));
				
				for(int ci = 0 ; ci < N ; ci++)
					for(int cj = 0 ; cj < M ; cj++)
						check[ci][cj] = false;
				
				check[i][j] = true;

				while(!q.isEmpty()) {
					point_2589 now = q.poll();
					int nowX = now.x;
					int nowY = now.y;
					int nowC = now.count;
					
					if(max < nowC)
						max = nowC;
					
					for(int move = 0 ; move < 4; move++) {
						int nextX = nowX + moveX[move];
						int nextY = nowY + moveY[move];
						
						if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !check[nextY][nextX] && map[nextY][nextX]) {
							q.add(new point_2589(nextX,nextY,(nowC+1)));
							check[nextY][nextX] = true;
						}
					}
						
				}
			}
		}
		System.out.println(max);
	}
}
class point_2589{
	int x;
	int y;
	int count;
	
	public point_2589(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
