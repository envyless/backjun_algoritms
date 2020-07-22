import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_10026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 배열의 크기
		char[][] insert = new char[N][N];
		boolean[][] visit = new boolean[N][N];
		Queue<point_10026> q = new LinkedList<point_10026>();
		int countN = 0;
		int countRG = 0;
		int[] moveX = {0,0,1,-1};
		int[] moveY = {1,-1,0,0};
		
		
		for(int i = 0 ; i < N ; i++) {
			String line = scn.next();
			scn.nextLine();
			for(int j = 0 ; j < line.length(); j++)
				insert[i][j] = line.charAt(j);
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visit[i][j])
					continue;
				countN++;
				q.add(new point_10026(j,i,insert[i][j]));
				
				while(!q.isEmpty()) {
					point_10026 now = q.poll();
					int x = now.x;
					int y = now.y;
					char c = now.c;
					
					if(visit[y][x] || c != insert[y][x])
						continue;
					
					visit[y][x] = true;
					
					for(int k = 0 ; k < 4 ; k++) {
						int nextX = x + moveX[k];
						int nextY = y + moveY[k];
						
						if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N)
							q.add(new point_10026(nextX, nextY, insert[y][x]));
					}
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				visit[i][j] = false;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visit[i][j])
					continue;
				
				countRG++;
				q.add(new point_10026(j,i,insert[i][j]));
				
				while(!q.isEmpty()) {
					point_10026 now = q.poll();
					int x = now.x;
					int y = now.y;
					char c = now.c;
					// c는 이전 것, y,x는 현재 것.
					if(visit[y][x])
						continue;
					
					if(c != insert[y][x]) {
						if(c == 'B' && insert[y][x] != 'B')
							continue;
						else if(c == 'R' && insert[y][x] == 'B')
							continue;
						else if(c == 'G' && insert[y][x] == 'B')
							continue;
					}
					
					visit[y][x] = true;
					
					for(int k = 0 ; k < 4 ; k++) {
						int nextX = x + moveX[k];
						int nextY = y + moveY[k];
						
						if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N)
							q.add(new point_10026(nextX, nextY, insert[y][x]));
					}
				}
			}
		}
		System.out.println(countN + " " + countRG);
	}
}
class point_10026{
	int x;
	int y;
	char c;
	
	public point_10026(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}