import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_7576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int M = scn.nextInt(); // 가로
		int N = scn.nextInt(); // 세로
		
		int[][] insert = new int[N][M];
		Queue<tomato> tmt = new LinkedList<tomato>();
		int oneDay = 0;
		int nextDay = 0;
		
		// 모든 값 입력 받기
		for(int i = 0 ; i < N ; i++) { // 세로 
			for(int j = 0 ; j < M ; j++) { // 가로
				insert[i][j] = scn.nextInt();
				if(insert[i][j] == 1) { // 익은 토마토가 있을 때 큐에 추가
					tmt.add(new tomato(j,i)); // insert (가로,세로)
					oneDay++;
				}
			}
		}
		
		
		int count = 0;
		int[] calx = { -1, 1, 0, 0 };
		int[] caly = { 0, 0, -1, 1 };
		
		// 익은 토마토 사용.
		while(!tmt.isEmpty()) {
			tomato t = tmt.poll();
			oneDay--;
			int x = t.getX(); // 가로
			int y = t.getY(); // 세로
			
			// 토마토는 상하좌우 4방향으로 움직임.
			for(int i = 0 ; i < 4 ; i++) {
				int tmpX = x + calx[i];
				int tmpY = y + caly[i];
				
				// x,y가 배열의 범위를 벗어나지 않을 때.
				if(tmpX >= 0 && tmpY >= 0 && tmpX < M && tmpY < N) {
					if(insert[tmpY][tmpX] == 0) {
						insert[tmpY][tmpX] = 1;
						tmt.add(new tomato(tmpX,tmpY));
						nextDay++;
					}
				}
			}
			if(oneDay == 0 && nextDay != 0 ) {
				count++;
				oneDay = nextDay;
				nextDay = 0;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(insert[i][j] == 0)
					count = -1;
			}
		}
		
		System.out.println(count);
	}
	
	
	
	public static class tomato {
		int x;
		int y;
		
		public tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}

}