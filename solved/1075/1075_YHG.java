import java.util.Scanner;

public class Problem_1075 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 100 ~ 2,000,000,000
		int F = scn.nextInt(); // 1 ~ 100
		
		N /= 100;
		N *= 100;
		int count = 0;
		while(count < 100) {
			if((N + count) % F != 0) {
				count++;
				continue;
			}
			
			if(count < 10)
				System.out.print(0);
			System.out.println(count);
			break;
		}
	}
}