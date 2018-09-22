import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_2583 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // y
		int M = scn.nextInt(); // x
		int K = scn.nextInt(); // 사각형의 수
		
		boolean[][] visit = new boolean[N][M];
		for(int i = 0 ; i < K ; i++) {
			int x1 = scn.nextInt();
			int y1 = scn.nextInt();
			int x2 = scn.nextInt();
			int y2 = scn.nextInt();
			
			for(int y = y1 ; y < y2 ; y++)
				for(int x = x1 ; x < x2 ; x++)
					visit[y][x] = true;
		}
		
		int area = 0;
		Queue<point_2583> q = new LinkedList<point_2583>();
		PriorityQueue<Integer> result = new PriorityQueue<Integer>(new ASC_2583());
		
		int[] moveX = { 0, 0, -1, 1};
		int[] moveY = { -1, 1, 0, 0};
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(visit[i][j])
					continue;
				int count = 0;
				
				area++;
				q.add(new point_2583(i,j));
				
				while(!q.isEmpty()) {
					point_2583 now = q.poll();
					int nowX = now.x;
					int nowY = now.y;
					
					if(visit[nowY][nowX])
						continue;
					
					count++;
					visit[nowY][nowX] = true;
					
					for(int k = 0 ; k < 4; k++) {
						int nextX = nowX + moveX[k];
						int nextY = nowY + moveY[k];
						
						if(nextX >=0 && nextY >= 0 && nextX < M && nextY < N) {
							if(!visit[nextY][nextX])
								q.add(new point_2583(nextY,nextX));
						}
					}
				}
				result.add(count);
			}
		}
		
		System.out.println(area);
		
		while(!result.isEmpty()) {
			int print = result.poll();
			System.out.print(print + " ");
		}
	}

}
class point_2583{
	int x;
	int y;
	
	public point_2583(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

class ASC_2583 implements Comparator<Integer>{
	
	public int compare(Integer v1, Integer v2) {
		return v1 - v2 < 0 ? -1 : 1;
    }
}