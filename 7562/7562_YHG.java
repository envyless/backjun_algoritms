import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_7562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			
			int L = scn.nextInt();
			boolean[][] visit = new boolean[L][L];
			int[] start = new int[2];
			int[] finish = new int[2];
			int result = 9999999;
			
			Queue<point> q = new LinkedList<point>();
			
			for(int i = 0 ; i < 2 ; i++)
				start[i] = scn.nextInt();
			
			for(int i = 0 ; i < 2 ; i++)
				finish[i] = scn.nextInt();
			
			visit[start[1]][start[0]] = true;
			q.add(new point(start[1], start[0], 0));
			
			while(!q.isEmpty()) {
				point now = q.poll();
				int nowX = now.x;
				int nowY = now.y;
				int count = now.count;
				boolean check = false;
				
				visit[nowY][nowX] = true;	
				
				if(nowX == finish[0] && nowY == finish[1]) {
					if(result > count)
						result = count;
				}
				
				int[] moveX = { -1, -2, 1, 2, -1, -2, 1, 2 };
				int[] moveY = { -2, -1, -2, -1, 2, 1, 2, 1 };
				
				for(int i = 0 ; i < 8 ; i++) {
					int tmpX = nowX + moveX[i];
					int tmpY = nowY + moveY[i];
					
					if(tmpX >= 0 && tmpY >= 0 && tmpX < L && tmpY < L) {
						if(!visit[tmpY][tmpX]) {
							visit[tmpY][tmpX] = true;
							if(!check) {
								count++;
								check = true;
							}
							q.add(new point(tmpY,tmpX,count));
						}
					}
				}
			}
			
			if(result == 9999999)
				System.out.println(0);
			else
				System.out.println(result);
		}
	}
	
	static class point {
		int x;
		int y;
		int count;
		
		public point(int y, int x, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}