import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_7569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int M = scn.nextInt(); // 가로
		int N = scn.nextInt(); // 세로
		int H = scn.nextInt(); // 높이
		int[][][] insert = new int[H][N][M];
		boolean[][][] planted = new boolean[H][N][M];
		Queue<plant_7569> q = new LinkedList<plant_7569>();
		
		int zeroCount = 0;
		for(int h = 0 ; h < H ; h++)
			for(int n = 0 ; n < N ; n++)
				for(int m = 0 ; m < M ; m++) {
					int tmp = scn.nextInt();
					insert[h][n][m] = tmp;
					if(tmp == 1)
						q.add(new plant_7569(h,n,m,0));
					if(tmp == 0)
						zeroCount++;
					if(tmp != 0)
						planted[h][n][m] = true;
				}
		
		if(zeroCount == 0) {
			System.out.println(0);
			return ;
		}
		
		int days = 0;
		while(!q.isEmpty()) {
			plant_7569 now = q.poll();
			int nowH = now.h;
			int nowN = now.n;
			int nowM = now.m;
			int nowD = now.day;
			
			if(days < nowD)
				days = nowD;
			
			int[] moveH = {1,-1,0,0,0,0};
			int[] moveN = {0,0,1,-1,0,0};
			int[] moveM = {0,0,0,0,-1,1};
			
			
			for(int i = 0 ; i < 6 ; i++) {
				int nextH = nowH + moveH[i];
				int nextN = nowN + moveN[i];
				int nextM = nowM + moveM[i];
				
				if(nextH >= 0 && nextH < H && nextN >= 0 && nextN < N && nextM >= 0 && nextM < M) {
					if(!planted[nextH][nextN][nextM]) {
						planted[nextH][nextN][nextM] = true;
						q.add(new plant_7569(nextH, nextN, nextM, nowD+1));
					}
				}
			}
		}
		
		
		for(int h = 0 ; h < H ; h++)
			for(int n = 0 ; n < N ; n++)
				for(int m = 0 ; m < M ; m++)
					if(!planted[h][n][m]) {
						System.out.println(-1);
						return ;
					}
		
		System.out.println(days);
		
	}
}
class plant_7569{
	int h;
	int n;
	int m;
	int day;
	
	public plant_7569(int h, int n, int m, int day) {
		this.h = h;
		this.n = n;
		this.m = m;
		this.day = day;
	}
}