import java.util.Scanner;

public class Problem_8979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// ������ ����
		int N = scn.nextInt();
		// ����� �˰���� ������ ��ȣ
		int K = scn.nextInt();
		// ������ȣ / �ݸ޴� / ���޴� / ���޴�
		int[][] insert = new int[N][4];
		// K�� �޴�
		int[] KM = new int[4];
		// K�� ���. 1����� ����.
		int num = 1;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				insert[i][j] = scn.nextInt();
			}
			if(insert[i][0] == K) {
				KM[1] = insert[i][1];
				KM[2] = insert[i][2];
				KM[3] = insert[i][3];
			}
		}
		
		
		// ��ü ��츦 Ȯ��
		for(int i = 0 ; i < N ; i++) {
			// �ݸ޴��� ���� ���
			if(insert[i][1] > KM[1]) {
				num++;
			}
			// �ݸ޴��� ���� ���. ���޴��� Ȯ���ؾ� ��.
			else if(insert[i][1] == KM[1]) {
				// ���޴��� �� �������
				if(insert[i][2] > KM[2]) {
					num++;
				}
				// ���޴޵� ���� ��� ���޴��� Ȯ���ؾ� ��.
				else if(insert[i][2] == KM[2]) {
					if(insert[i][3] > KM[3]) {
						num++;
					}
				}
			}
		}
		
		System.out.println(num);
	}
}
