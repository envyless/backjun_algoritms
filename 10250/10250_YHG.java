import java.util.Scanner; // Scanner�� �Է� �ޱ� ���� ���

public class Problem_10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		// �׽��� �������� ����
		int t = scn.nextInt();
		
		int[] h = new int[t];
		int[] w = new int[t];
		int[] n = new int[t];
		
		for(int i = 0 ; i < t ; i++) {
			h[i] = scn.nextInt();
			w[i] = scn.nextInt();
			n[i] = scn.nextInt();
		}
		
		for(int i = 0 ; i < t ; i++) {
			// while ������ ���� ����
			int h_tmp = 0;
			int w_tmp = 0;
			
			while(n[i] > 0) {
				n[i]--;
				//���� ������ ȣ�� ����.
				if(n[i] != 0) {
					h_tmp++;
					// ũ�� h �迭�� index�� 0 ~ h-1
					if(h_tmp > h[i]-1) {
						h_tmp = 0;
						w_tmp++;
					}
				}
			}
			// ��� ����� X�� ��, Y�� ȣ����� �� ��, XYY, XXYY �� ������. 
			// ��, ȣ���� 10 �̸��� ���� 0�� �ٿ��� ���
			String prt = "";
			prt += h_tmp+1;
			if(w_tmp < 9 ) prt += 0;
			prt += w_tmp+1;
			System.out.println(prt);
		}
	}
}
