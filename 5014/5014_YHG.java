import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_5014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int F = scn.nextInt(); // �ǹ� ���� , 1�̻� 100�� ����
		int S = scn.nextInt(); // ���� ��ġ , 1�̻�
		int G = scn.nextInt(); // ������ ��ġ , 1�̻� 100�� ����. 
		int U = scn.nextInt(); // up , 0 �̻�
		int D = scn.nextInt(); // down , 100�� ����.
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[F+1]; // ������ 0�� �ƴ� 1���� ����.
		int[] click = new int[F+1];
		
		q.add(S);
		
		if(S == G) 
			System.out.println(0);
		else {
			
			visit[S] = true;
			while(!q.isEmpty()) {
				
				int check = q.poll();
				
				int up = check + U; // up �� 100�� �̻��� ���� ������ �� ���� ��ȿ.
				int down = check - D; // down �� 0 ������ ���� ������ �� ���� ��ȿ.
				
				if( up <= F && !visit[up] ) {
					visit[up] = true;
					click[up] = click[check] + 1;
					q.add(up);
				}
				
				if(down > 0 && !visit[down] ) {
					visit[down] = true;
					click[down] = click[check] + 1;
					q.add(down);
				}
				
			}
			
			if(click[G] == 0)
				System.out.println("use the stairs");
			else
				System.out.println(click[G]);
		}
	}
}