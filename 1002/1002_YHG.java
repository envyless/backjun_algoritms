import java.util.Scanner;

public class Problem_1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt(); // �׽�Ʈ ���̽�
		
		for(int TT = 0 ; TT < T ; TT++) {
			int x1 = scn.nextInt();
			int y1 = scn.nextInt();
			int r1 = scn.nextInt();
			int x2 = scn.nextInt();
			int y2 = scn.nextInt();
			int r2 = scn.nextInt();
			
			
			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) { // x,y ��ǥ�� ���� �� �Ÿ��� ������ ���Ѵ�
					System.out.println(-1);
					continue;
				}
				else { // x,y ��ǥ�� ���� �� �Ÿ��� �ٸ��� 0
					System.out.println(0);
					continue;
				}
			}
			
			if(r1 == 0 || r2 == 0) // �Ÿ� �ϳ��� 0 �� ��.
				if(x1 != x2 || y1 != y2) { // ��ǥ�� �ٸ�.
					System.out.println(1);
					continue;
				}
			
			//������ ���ų�, �� ������ �����ų�, �� ������ ����.
			int len = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			int people = (int)Math.pow(r1+r2, 2);
			int tmp = (int)Math.pow(Math.abs(r1-r2), 2);
			
			if(len == people) System.out.println(1);
			else if(len > people) System.out.println(0);
			else
				if(tmp == len) System.out.println(1); // ����
				else if(tmp < len) System.out.println(2);
				else System.out.println(0); // ����
		}
	}
}