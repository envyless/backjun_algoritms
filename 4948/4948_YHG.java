import java.util.Scanner;

public class Problem_4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			
			int N = scn.nextInt(); // 자연수 n
			int count = 0;
			
			if(N == 0) break;
			
			if(N == 1) System.out.println(1);
			else {
				
				for(int i = N + 1 ; i <= (2 * N) ; i++) {
					if(i % 2 != 0) { // 짝수로 나누어 지지 않으면. 홀수도 생각해봐야 함.
						// 홀수 체크.
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