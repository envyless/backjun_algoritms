import java.util.Scanner;

public class Problem_1904 {
	static int MOD = 15746;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ±æÀÌ
		
		int first = 1; // N == 1  > 1
		int second = 2; // N == 2 > 2
		
		if(N == 1) System.out.println(first);
		else if(N == 2) System.out.println(second);
		else {
			int tmp = 0;
			for(int i = 3 ; i <= N ; i++) {
				tmp = (first + second) % MOD;
				first = second;
				second = tmp;
			}
			System.out.println(second);
		}
	}
}