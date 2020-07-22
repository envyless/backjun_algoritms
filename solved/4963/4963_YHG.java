import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_4963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			int w = scn.nextInt();
			int h = scn.nextInt();
			if(w == 0 && h == 0)
				break;
			
			int[][] insert = new int[h][w];
			boolean[][] visit = new boolean[h][w];
			Queue<land> q = new LinkedList<>();
			int calX[] = { -1, 1, 0, 0 , -1, -1, 1, 1};
			int calY[] = { 0, 0, -1, 1 , -1, 1, -1, 1};
			
			for(int i = 0 ; i < h ; i++)
				for(int j = 0 ; j < w ; j++)
					insert[i][j] = scn.nextInt();
			
			int count = 0;
			
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if(visit[i][j]) continue;
					
					visit[i][j] = true;
					if(insert[i][j] == 1) {
						int x = j;
						int y = i;
						
						for(int K = 0 ; K < 8 ; K++) {
							int tmpX = x + calX[K];
							int tmpY = y + calY[K];
							if(tmpX >= 0 && tmpY >= 0 && tmpX < w && tmpY < h) 
								if(!visit[tmpY][tmpX] && insert[tmpY][tmpX] == 1)
									q.add(new land(tmpY,tmpX));
						}
						
						while(!q.isEmpty()) {
							land now = q.poll();
							int nowX = now.x;
							int nowY = now.y;
					
							if(!visit[nowY][nowX]) {
								visit[nowY][nowX] = true;
								for(int K = 0 ; K < 8 ; K++) {
									int tmpX = nowX + calX[K];
									int tmpY = nowY + calY[K];
									if(tmpX >= 0 && tmpY >= 0 && tmpX < w && tmpY < h) 
										if(!visit[tmpY][tmpX]  && insert[tmpY][tmpX] == 1)
											q.add(new land(tmpY,tmpX));
								}
							}
						}
						count++;
					}
				}
			}
			System.out.println(count);
		}	
	}
	
	static class land{
		int x;
		int y;
		
		public land(int y,int x) {
			this.x = x;
			this.y = y;
		}
	}
}