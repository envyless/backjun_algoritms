import java.util.Scanner;

public class Problem_4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			
			int N = scn.nextInt(); // �ڿ��� n
			int count = 0;
			
			if(N == 0) break;
			
			if(N == 1) System.out.println(1);
			else {
				
				for(int i = N + 1 ; i <= (2 * N) ; i++) {
					if(i % 2 != 0) { // ¦���� ������ ���� ������. Ȧ���� �����غ��� ��.
						// Ȧ�� üũ.
						for(int j = 3 ; j*j <= i ; j+=2) {
							if(i % j == 0) {
								count--;
								break;
							}
						}
						count++;
					}
				}
				
				System.out.println(count);
			}
		}
	}
}