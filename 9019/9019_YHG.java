import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_9019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt(); // �׽�Ʈ ���̽�
		
		for(int TT = 0 ; TT < T ; TT++) {
			int A = scn.nextInt(); // A > B
			int B = scn.nextInt();
			boolean[] check = new boolean[10000];
			Queue<value_9019> q = new LinkedList<value_9019>();
			q.add(new value_9019(A,""));

			while(!q.isEmpty()) {
				value_9019 now = q.poll();
				int nowV = now.x;
				String nowS = now.y;
				
				if(nowV == B) {
					System.out.println(nowS);
					break;
				}
				// D : n �� 2���. ������ �Ѿ�� ������
				int tmp = nowV * 2;
				if(tmp > 9999)
					tmp %= 10000;
				if(!check[tmp]) {
					check[tmp] = true;
					q.add(new value_9019(tmp, nowS+"D"));
				}
				// S : 1�� �� ���. ������ �Ѿ�� 9999
				tmp = nowV - 1;
				if(tmp < 0)
					tmp = 9999;
				if(!check[tmp]) {
					check[tmp] = true;
					q.add(new value_9019(tmp, nowS+"S"));
				}
				// L : �������� �̵�
				tmp = nowV % 1000;
				int tmp2 = nowV / 1000;
				tmp = tmp * 10 + tmp2;
				if(!check[tmp]) {
					check[tmp] = true;
					q.add(new value_9019(tmp, nowS+"L"));
				}
				// R : ���������� �̵�
				tmp = nowV / 10;
				tmp2 = nowV % 10;
				tmp += tmp2 * 1000;
				if(!check[tmp]) {
					check[tmp] = true;
					q.add(new value_9019(tmp, nowS+"R"));
				}
			}
		}
	}
}
class value_9019{
	int x;
	String y;
	
	public value_9019(int x, String y) {
		this.x = x;
		this.y = y;
	}
}