import java.util.Scanner;

public class Problem_1024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // ��
		int L = scn.nextInt(); // ����
		// ���� �ƴ�. > 0 ����.
		
		for(int i = L ; i <= 100 ; i++) {
			for(int j = (N / i + 1) ; j >= 0 ; j--) {
				long value = ( j * i ) + i * ( i - 1 ) / 2; // j ���� ���ӵ� i���� ������ ��. �ñ׸� ����.
				if(N == value) {
					for(int k = 0 ; k < i ; k++, j++)
						System.out.print(j + " ");
					return ;
				}
				else if( value < N)
					break;
			}
		}
		System.out.println(-1);
	}
}