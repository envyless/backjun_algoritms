import java.util.Scanner;

public class Problem_1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			
			int left = scn.nextInt();
			int right = scn.nextInt();
			
			int tmp = right - left;
			
			double result = 1;
			int j = 1;
			
			if(tmp == 0) {
				System.out.println((int)result);
				continue;
			}
			
			for(int i = tmp+1 ; i <= right ; i++) {
				result *= i;
				if(j <= left) {
					result /= j;
					j++;
				}
			}
			
			if(j <= left)
				for(; j<= left ; j++)
					result /= j;
			
			System.out.println((int)result);
		}
	}
}
