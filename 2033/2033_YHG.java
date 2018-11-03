import java.util.Scanner;

public class Problem_2033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int start = 10;
		
		while(start <= N) {
			int tmp = N % start; // ³ª¸ÓÁö
			N /= start;
			N *= start;
			if(tmp >= 5*start/10)
				N += start;
			start *= 10;
		}
		System.out.println(N);
	}
}