import java.util.Scanner; // Scanner�� �Է� �ޱ� ���� ���

public class Problem_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int N;
		int count = 0;
		
		N = scn.nextInt();
		
		if(N == 3) count = 1;
		else if(N == 4) count = -1;
		else { // 5 �̻��� ���
			
			if(N % 5 == 0) { // 5�� �� ������ ������ ���
				count = N/5;
			}
			else {
				// 5�� �� ������ ���� ���� ���
				int tmp;
				
				// N���� 5�� ����� �� �� 3���� ������ ����.
				for(int i = 5; i < N ; i+=5) {
					tmp = N - i;
					// 5�� ����� �� ���� 3���� ������ ����
					if(tmp % 3 == 0) {
						count = tmp/3;
						count += i/5;
					}
				}
				
				// 5�� ����� �� ���� 3���� ������ �������� count ���� 0�� �ƴϴ�.
				// 0�̶�� ���� 5�� ����� �� �� �� 3���� ���������� �ʴ´ٴ� ��.
				if(count == 0) {
					// N�� 3�� ����� ���
					if(N % 3 == 0) {
						count = N/3;
					}
				}
			}
			
		}
		
		// ���� ���ǿ� �ѹ��� �ش����� ������ 3,5�� �� ���������� �ʴ´ٴ� ��.
		if(count == 0) count = -1;
		
		System.out.println(count);
	}
}
