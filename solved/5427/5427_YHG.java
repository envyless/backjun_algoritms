import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_5427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int TT = Integer.parseInt(br.readLine());
		
		for(int T = 0 ; T < TT ; T++) {
			st = new StringTokenizer(br.readLine()," ");
			int row = Integer.parseInt(st.nextToken()); // 가로
			int cal = Integer.parseInt(st.nextToken()); // 세로
			
			// . : 빈공간 , # : 벽 , @ : 시작위치 , * : 불 
			boolean[][] visit = new boolean[cal][row];
			boolean check = false;
			Queue<point_5427> q = new LinkedList<point_5427>();
			Queue<fire_5427> f = new LinkedList<fire_5427>();
			int pCount = 0;
			int fCount = 0;
			
			char[][] insert = new char[cal][row];
			for(int i = 0 ; i < cal ; i++) {
				String tmp = br.readLine();
				for(int j = 0 ; j < row ; j++) {
					insert[i][j] = tmp.charAt(j);
					if(tmp.charAt(j) == '@') {
						q.add(new point_5427(j, i,0));
						pCount++;
						visit[i][j] = true;
					}
					else if(tmp.charAt(j) == '*') {
						f.add(new fire_5427(j,i));
						fCount++;
						visit[i][j] = true;
					}
					else if(tmp.charAt(j) == '#')
						visit[i][j] = true;
				}
			}
			
			while(!q.isEmpty()) {
				int tmp = fCount;
				fCount = 0;
				
				int[] moveX = { -1, 1, 0, 0 };
				int[] moveY = { 0, 0, -1, 1 };
				
				while(tmp > 0) {
					tmp--;
					fire_5427 now = f.poll();
					
					int nowX = now.x;
					int nowY = now.y;
					for(int i = 0 ; i < 4 ; i++) {
						int nextX = nowX + moveX[i];
						int nextY = nowY + moveY[i];
						
						if(nextX >= 0 && nextY >= 0 && nextX < row && nextY < cal && !visit[nextY][nextX]) {
							f.add(new fire_5427(nextX,nextY));
							fCount++;
							visit[nextY][nextX] = true;
						}
					}
				}
				
				tmp = pCount;
				pCount = 0;
				
				while(tmp > 0) {
					tmp--;
					
					point_5427 now = q.poll();
					int nowX = now.x;
					int nowY = now.y;
					int nowC = now.count;
					
					for(int i = 0 ; i < 4 ; i++) {
						int nextX = nowX + moveX[i];
						int nextY = nowY + moveY[i];
						int nextC = nowC + 1;
						
						if(nextX >= 0 && nextY >= 0 && nextX < row && nextY < cal)
							if(visit[nextY][nextX])
								continue;
						
						if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= cal) {
							System.out.println(nextC);
							check = true;
							break;
						}
						else {
							pCount++;
							visit[nextY][nextX] = true;
							q.add(new point_5427(nextX,nextY,nextC));
						}
					}
					if(check) // while out.
						break;
				}
				if(check)
					break;
			}
			
			if(!check)
				System.out.println("IMPOSSIBLE");
		}
	}
}
class point_5427{
	int x;
	int y;
	int count;
	
	public point_5427(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
class fire_5427{
	int x;
	int y;
	
	public fire_5427(int x, int y) {
		this.x = x;
		this.y = y;
	}
}