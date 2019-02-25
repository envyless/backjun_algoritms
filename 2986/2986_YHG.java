import java.util.Scanner;

public class Problem_2986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int tmp = 1;
		
		for(int i = 2 ; i * i <= N ; i++) {
			if(N % i == 0) {
				tmp = N / i;
				break;
			}
		}
		System.out.println(N-tmp);
	}
}