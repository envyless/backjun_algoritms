import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2468 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // �ڿ��� ����
		int[][] insert = new int[N][N];
		Queue<ground> q = new LinkedList<>();
		int max = 0;
		int result = 0;
		int maxResult = 0;
		
		for(int i = 0 ; i < N ; i++) 
			for(int j = 0 ; j < N ; j++) {
				insert[i][j] = scn.nextInt();
				if(insert[i][j] > max) 
					max = insert[i][j];
			}
		
		
		// �� ������ �ִ� ���̿� �������� ������, ������ ������ ����.
		for(int i = 0 ; i < max ; i++) {
			
			boolean[][] check = new boolean[N][N];
			int[][] check2 = new int[N][N];
			
			for(int y = 0 ; y < N ; y++) {
				for(int x = 0 ; x < N ; x++) {
					// ���������� ������
					if(i < insert[y][x]) {
						q.add(new ground(y,x));
					}
					
					check[y][x] = false;
					check2[y][x] = 0;
				}
			}
			
			
			while(!q.isEmpty()) {
				
				ground tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				Queue<ground> qq = new LinkedList<>();
				
				if(!check[y][x]) {
					check[y][x] = true;
					check2[y][x]++;
					int calX[] = { -1, 1, 0, 0 };
					int calY[] = { 0, 0, -1, 1 };
					
					for(int K = 0 ; K < 4 ; K ++) {
						int tmpX = x + calX[K];
						int tmpY = y + calY[K];
						
						// �ش� ��ġ�� �迭�� �����ȿ� �� �ְ�, �ش� ��ġ�� ���������� ���� ��쿡�� ��.
						if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < N && insert[tmpY][tmpX] > i) {
							if(!check[tmpY][tmpX]) {
								qq.add(new ground(tmpY,tmpX));
							}
						}
					}
					
					while(!qq.isEmpty()) {
						
						ground tmp2 = qq.poll();
						int xx = tmp2.x;
						int yy = tmp2.y;
						
						if(!check[yy][xx]) {
							check[yy][xx] = true;
							check2[yy][xx]++;
							
							for(int K = 0 ; K < 4 ; K ++) {
								int tmpX = xx + calX[K];
								int tmpY = yy + calY[K];
								
								// �ش� ��ġ�� �迭�� �����ȿ� �� �ְ�, �ش� ��ġ�� ���������� ���� ��쿡�� ��.
								if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < N && insert[tmpY][tmpX] > i) {
									if(!check[tmpY][tmpX]) {
										qq.add(new ground(tmpY,tmpX));
									}
								}
							}
						}
					}
					
					result++;
				}
			}
			
			if(maxResult < result)
				maxResult = result;
			result = 0;
			
		}
		
		System.out.println(maxResult);
		
	}

	static class ground{
		int x;
		int y;
		
		public ground(int y,int x) {
			this.x = x;
			this.y = y;
		}
	}
}
