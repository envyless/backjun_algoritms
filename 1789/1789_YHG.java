import java.util.Scanner;

public class Problem_1789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		long N = scn.nextLong(); // �ڿ����� ��
		
		int count = 0;
		int i = 1;
		
		while(true) {
			if(N - i >= 0) {
				N -= i;
				count++;
				i++;
			}
			else 
				break;
		}
		System.out.println(count);
	}
}
