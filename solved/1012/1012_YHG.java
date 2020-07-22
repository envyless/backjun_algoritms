import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt(); // �׽�Ʈ ���̽��� ����
		
		for(int TC = 0 ; TC < T ; TC++) {
			int M = scn.nextInt(); // ���߹��� ���� ����
			int N = scn.nextInt(); // ���߹��� ���� ����
			int K = scn.nextInt(); // ���߰� �ɾ��� �ִ� ��ġ�� ����

			boolean[][] grd = new boolean[N][M];
			Queue<plants> q = new LinkedList<plants>();
			
			int saveX = 0;
			int saveY = 0;
			int count = 0;
			
			for(int i = 0 ; i < K ; i++) {
				saveX = scn.nextInt();
				saveY = scn.nextInt();
				grd[saveY][saveX] = true;
			}
			
			while(K > 0) {
				int x = saveX;
				int y = saveY;
				
				K--;
				count++;
				grd[y][x] = false;
				
				int[] calX = { -1, 1, 0, 0 };
				int[] calY = { 0, 0, -1, 1 };
				
				for(int i = 0 ; i < 4 ; i++) {
					int tmpX = x + calX[i];
					int tmpY = y + calY[i];
					// index ���� �ȿ� ���� ��쿡�� ����
					if(tmpX >= 0 && tmpY >= 0 && tmpX < M && tmpY < N) {
						
						// �����¿쿡 ���߰� ������
						if(grd[tmpY][tmpX] == true) {
							grd[tmpY][tmpX] = false;
							q.add(new plants(tmpX,tmpY));
						}
					}
				}
				
				while(!q.isEmpty()) {
					plants pts = q.poll();
					int xX = pts.x;
					int yY = pts.y;
					
					K--;
					
					for(int i = 0 ; i < 4 ; i++) {
						int tmpX = xX + calX[i];
						int tmpY = yY + calY[i];
						// index ���� �ȿ� ���� ��쿡�� ����
						if(tmpX >= 0 && tmpY >= 0 && tmpX < M && tmpY < N) {
							
							// �����¿쿡 ���߰� ������
							if(grd[tmpY][tmpX] == true) {
								grd[tmpY][tmpX] = false;
								q.add(new plants(tmpX,tmpY));
							}
						}
					}
				}
				
				for(int i = 0; i < N ; i++) {
					for(int j = 0 ; j < M ; j++) {
						if(grd[i][j] == true) {
							saveY = i;
							saveX = j;
							break;
						}
					}
				}
			}
			System.out.println(count);
		}		
	}
}

class plants {
	int x;
	int y;
	
	public plants(int x, int y) {
		this.x = x;
		this.y = y;
	}
}