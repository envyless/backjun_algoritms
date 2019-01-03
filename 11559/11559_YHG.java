import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_11559 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		char[][] insert = new char[12][6];
		boolean[][] visit = new boolean[12][6];
		Queue<point_11559> q = new LinkedList<point_11559>();
		Queue<point_11559> remove = new LinkedList<point_11559>();
		for(int i = 0 ; i < 12 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < 6 ; j++)
				insert[i][j] = tmp.charAt(j);
		}
		
		int[] moveX = { 1, -1, 0, 0};
		int[] moveY = {0, 0, 1, -1};
		
		int result = 0;
		while(true) {
			for(int i = 0 ; i < 12 ; i++)
				for(int j = 0 ; j < 6 ; j++)
					visit[i][j] = false;
			
			boolean check = false;
			
			for(int i = 11 ; i >= 0 ; i--) {
				for(int j = 0 ; j < 6 ; j++) {
					if(visit[i][j] || insert[i][j] == '.')
						continue;
					
					char color = insert[i][j];
					visit[i][j] = true;
					q.add(new point_11559(j,i));
					remove.add(new point_11559(j,i));
					int count = 1;
					while(!q.isEmpty()) {
						point_11559 now = q.poll();
						int nowX = now.x;
						int nowY = now.y;
						
						for(int k = 0 ; k < 4 ; k++) {
							int nextX = nowX + moveX[k];
							int nextY = nowY + moveY[k];
							
							if(nextX >= 0 && nextY >= 0 && nextX < 6 && nextY < 12 && !visit[nextY][nextX]) {
								if(insert[nextY][nextX] != color)
									continue;
								visit[nextY][nextX] = true;
								q.add(new point_11559(nextX,nextY));
								remove.add(new point_11559(nextX,nextY));
								count++;
							}
						}
					}
					
					if(count >= 4) {
						while(!remove.isEmpty()) {
							point_11559 now = remove.poll();
							int nowX = now.x;
							int nowY = now.y;
							
							insert[nowY][nowX] = '.';
							check = true;
						}
					}
					remove.clear();
				}
			}
			if(!check)
				break;
			result++;
			
			for(int i = 0 ; i < 6 ; i++) {
				for(int j = 10 ; j >= 0 ; j--) {
					if(insert[j][i] == '.')
						continue;
					
					int tmp = j;
					while(insert[tmp+1][i] == '.') {
						insert[tmp+1][i] = insert[tmp][i];
						insert[tmp][i] = '.';
						tmp++;
						if(tmp == 11)
							break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
class point_11559{
	int x;
	int y;
	
	public point_11559(int x, int y) {
		this.x = x;
		this.y = y;
	}
}