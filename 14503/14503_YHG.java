import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_14503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // ����
		int m = scn.nextInt(); // ����
		
		int r = scn.nextInt(); // �κ� ��ġ ����
		int c = scn.nextInt(); // �κ� ��ġ ����
		int d = scn.nextInt(); // ���� 0:��, 1:��, 2:��, 3:��
		Queue<position_14503> q = new LinkedList<position_14503>();
		q.add(new position_14503(r,c,d));
		
		int[][] insert = new int[n][m]; // 1 : �� , 0 : ��ĭ
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
			int s = position.d;  // ���� 0:��, 1:��, 2:��, 3:��
			
			// �������� �̵�.
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
					// û�� �Ǿ��ִ� ��� ���⸸ �ٲ�
					else {
						check++;
						q.add(new position_14503(y,x,s));
					}
				}
				// ���� ��� ���� �ٲ�
				else {
					check++;
					q.add(new position_14503(y,x,s));
				}
			}
			 // 4���� �˻簡 ���� ��
			else {
				// 2�� ������ �� ���� ���� ������ �� ��
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