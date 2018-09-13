import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_14503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // 세로
		int m = scn.nextInt(); // 가로
		
		int r = scn.nextInt(); // 로봇 위치 세로
		int c = scn.nextInt(); // 로봇 위치 가로
		int d = scn.nextInt(); // 방향 0:북, 1:동, 2:남, 3:서
		Queue<position_14503> q = new LinkedList<position_14503>();
		q.add(new position_14503(r,c,d));
		
		int[][] insert = new int[n][m]; // 1 : 벽 , 0 : 빈칸
		boolean[][] visit = new boolean[n][m]; 
		for(int i = 0 ; i < n ; i++)
			for(int j = 0 ; j < m ; j++) 
				insert[i][j] = scn.nextInt();
			
			
		
		int clean = 1;
		visit[r][c] = true;
		int check = 0;
		
		while(!q.isEmpty()) {
			position_14503 position = q.poll();
			int y = position.y;
			int x = position.x;
			int s = position.d;  // 방향 0:북, 1:동, 2:남, 3:서
			
			// 왼쪽으로 이동.
			if(s == 0) s = 3;
			else s--;
			
			int[] moveR = {-1, 0, 1, 0};
			int[] moveC = {0, 1, 0, -1};
			
			int moveY = y + moveR[s];
			int moveX = x + moveC[s];
			
			if(check != 4) {
				if(insert[moveY][moveX] == 0) {
					if(!visit[moveY][moveX]) {
						clean++;
						check = 0;
						visit[moveY][moveX] = true;
						q.add(new position_14503(moveY,moveX,s));
					}
					// 청소 되어있는 경우 방향만 바꿈
					else {
						check++;
						q.add(new position_14503(y,x,s));
					}
				}
				// 벽인 경우 방향 바꿈
				else {
					check++;
					q.add(new position_14503(y,x,s));
				}
			}
			 // 4방향 검사가 끝난 후
			else {
				// 2번 돌리면 앞 쪽이 원래 상태의 뒷 쪽
				if(s == 0) s = 3;
				else s--;
				moveY = y + moveR[s];
				moveX = x + moveC[s];
				if(insert[moveY][moveX] == 1) 
					break;
				else {
					for(int w = 0 ; w < 2 ; w++)
						if(s == 3) s = 0;
						else s++;
					check = 0;
					q.add(new position_14503(moveY,moveX,s));
				}
			}
		}
		
		System.out.println(clean);
	}
}

class position_14503{
	int x;
	int y;
	int d;
	
	public position_14503(int y, int x, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}