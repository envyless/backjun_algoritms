import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1600 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // �� �̵� ��
		int W = scn.nextInt(); // ����
		int H = scn.nextInt(); // ����
		int[][] insert = new int[H][W];
		
		for(int i = 0 ; i < H ; i++)
			for(int j = 0 ; j < W ; j++)
				insert[i][j] = scn.nextInt();
		
		Queue<move_1600> q = new LinkedList<move_1600>();
		boolean[][][] visit = new boolean[H][W][N+1];
		int count = 9999999;
		q.add(new move_1600(0,0,N,0));
		
		// 0,0 > H,W �� �̵�. �� ó�� �̵��ϴ� ���� N��.
		while(!q.isEmpty()) {
			move_1600 now = q.poll();
			int x = now.W;
			int y = now.H;
			int n = now.N;
			int m = now.M;
			
			if(visit[y][x][n])
				continue;
			if(x == W-1 && y == H-1)
				if(count > m) {
					count = m;
					continue;
				}
			
			visit[y][x][n] = true;
			
			int[] moveX = {0, 0, 1, -1};
			int[] moveY = {1, -1, 0, 0};
			
			for(int i = 0 ; i < 4 ; i++) {
				int tmpX = x + moveX[i];
				int tmpY = y + moveY[i];
				
				if(tmpX >= 0 && tmpY >= 0 && tmpX < W && tmpY < H && !visit[tmpY][tmpX][n])
					if(insert[tmpY][tmpX] != 1)
						q.add(new move_1600(tmpX, tmpY, n, m+1));
			}
			// visit �Լ��� ����
			
			
			// ���� ��/��2 + ��/��1 or ��/��1 + ��/��2
			if(n < 1)
				continue;
			
			int[] moveHX = {2, 2, -2, -2, 1, 1, -1, -1}; // + �� - ��
			int[] moveHY = {1, -1, 1, -1, 2, -2, 2, -2}; // + �� - ��
			
			for(int i = 0 ; i < 8 ; i++) {
				int tmpX = x + moveHX[i];
				int tmpY = y + moveHY[i];
				
				if(tmpX >= 0 && tmpY >= 0 && tmpX < W && tmpY < H && !visit[tmpY][tmpX][n-1])
					if(insert[tmpY][tmpX] != 1)
						q.add(new move_1600(tmpX, tmpY, n-1, m+1));
			}
		}
		
		if(count == 9999999)
			count = -1;
		System.out.println(count);
	}
}
class move_1600{
	int W;
	int H;
	int N;
	int M;
	
	public move_1600(int W, int H, int N, int M) {
		this.W = W;
		this.H = H;
		this.N = N;
		this.M = M;
	}
}