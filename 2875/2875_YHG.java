import java.util.Scanner; // Scanner�� �Է� �ޱ� ���� ���

public class Problem_2875 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();
		
		int count = 0;
		int tmp = 0;
		
		if(n/2 > m) {
			// n/2 �� m���� ũ�ٴ� ����, ���� �� ����� ���� ���ڰ� ���´ٴ� ��.
			tmp += n - m*2;
			
			// ���� 2 : ���� 1 �� ��. ���ڰ� ���´ٴ� ����, ������ ��� m ��ŭ�� ���� ��������ٴ� ��
			count = m;
			
		} else if (n/2 < m){
			// �׷��� �ʴٴ� ���� ���ڰ� ���´ٴ� ��.
			tmp += m - n/2;
			
			// ���ڰ� ���´ٴ� ����, ������ ���/2 �� ��ŭ�� ���� ����� ���ٴ� ��.
			count = n/2;
			
			if(n%2 != 0)	// n�� 2�� ������ �������� �ʴ´ٴ� ����, ���� �Ѹ��� ������ ���´ٴ� ��.
				tmp += 1;
					
		} else {
			// n/2 == m �̶�� ����, �� �¾� �������ٴ� ��.
			count = m;
			
			if(n%2 != 0)	// ���� �� ���� ��, n/2�� ����� �����̱� ������ �������� �ִ� ���, �Ѹ��� ���ڰ� ���� �ȴ�.
				tmp += 1;
		}
		
		if( k == 0 ) 
			System.out.println(count);
		else {
			k -= tmp;
			if(k > 0) {
				// ���� �̷��� ���� ����� ���Ͻ����� ���� �ο��� ������ ���. ���� �ϳ��� ��ü�ϸ鼭 ī��Ʈ �Ѵ�.
				while(true) {
					// �� �ϳ��� ��ü�ϰ� �� 3���� ���Ͻ� �ο����� �Ҵ��Ѵ�.
					count--;
					k -= 3;
					
					// ���Ͻ� �Ҵ� �ο��� 0���ϰ� �Ǹ� while �� ������.
					if(k <= 0 ) break;
				}
				System.out.println(count);
				
			} else	// ���� �̷��� ���� ����� ���Ͻ� �ο����� Ŭ ���. ���� ���� �״��.
				System.out.println(count);
		}

	}

}
