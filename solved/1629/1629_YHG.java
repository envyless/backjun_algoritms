import java.util.Scanner;

public class Problem_1629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int A = scn.nextInt(); 
		int B = scn.nextInt();
		int C = scn.nextInt();
		
		long result = cal(A,B,C);
		
		System.out.println(result);
	}
	
	// A를 B번 곱한 수를 C로 나눈 나머지 값을 구해야 한다.
	public static long cal(int A, int B, int C) {
		long tmp = 0;
		// A^4 = A^2 * A^2;
		// A^5 = A * A^2 * A^2;
		if(B == 1)
			return A%C;
		if(B == 0)
			return 1;
		if(B%2 == 0) {
			tmp = cal(A,B/2,C);
			return (tmp * tmp) % C;
		}
		else{
			tmp = cal(A,(B-1)/2,C);
			long tmp2 = (tmp * tmp) % C;
			return (A * tmp2) % C;
		}
	}
}