import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_2573 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 행 , 세로
		int M = scn.nextInt(); // 열 , 가로
		
		int[][] insert = new int[N][M];
		int[][] nextLand = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		Queue<point_2573> q = new LinkedList<point_2573>();
		Queue<point_2573> q2 = new LinkedList<point_2573>();
		int[] moveX = { 1, -1, 0, 0};
		int[] moveY = { 0, 0, 1, -1};
		
		for(int i = 0 ; i < N ; i++) 
			for(int j = 0 ; j < M ; j++) {
				int tmp = scn.nextInt();
				insert[i][j] = tmp;
				if(tmp != 0) 
					q.add(new point_2573(i,j));
			}
		
		int count = 0;
		int years = 0;
		
		while(true) {
			// 섬 칸수 확인.
			while(!q.isEmpty()) {
				point_2573 now = q.poll();
				int x = now.x;
				int y = now.y;
				
				if(visit[y][x])
					continue;
				visit[y][x] = true;
				count++;
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = x + moveX[i];
					int nextY = y + moveY[i];
					
					if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N)
						if(insert[nextY][nextX] != 0 && !visit[nextY][nextX]) 
							q2.add(new point_2573(nextY,nextX));
				}
				
				while(!q2.isEmpty()) {
					point_2573 next = q2.poll();
					int x2 = next.x;
					int y2 = next.y;
					
					if(visit[y2][x2])
						continue;
					visit[y2][x2] = true;
					
					for(int i = 0 ; i < 4 ; i++) {
						int nextX = x2 + moveX[i];
						int nextY = y2 + moveY[i];
						
						if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N)
							if(insert[nextY][nextX] != 0 && !visit[nextY][nextX]) 
								q2.add(new point_2573(nextY,nextX));
					}
				}
			}
			
			if(count >= 2) {
				System.out.println(years);
				return;
			}
			
			// 변수 초기화
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < M ; j++)
					visit[i][j] = false;
			count = 0;
			
			// 섬 크기 줄이기.
			years++;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(insert[i][j] == 0)
						continue;
					
					int sea = 0;
					for(int k = 0 ; k < 4 ; k++) {
						int nextY = i + moveY[k];
						int nextX = j + moveX[k];
						
						if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N)
							if(insert[nextY][nextX] == 0)
								sea++;
					}
					
					nextLand[i][j] = insert[i][j] - sea;
					if(nextLand[i][j] < 0)
						nextLand[i][j] = 0;
				}
			}
			
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < M ; j++) {
					insert[i][j] = nextLand[i][j];
					if(insert[i][j] != 0) 
						q.add(new point_2573(i,j));
				}
			
			if(q.isEmpty()) {
				System.out.println(0);
				return ;
			}
		}
		
	}

}
class point_2573{
	int x;
	int y;
	
	public point_2573(int y, int x) {
		this.x = x;
		this.y = y;
	}
}