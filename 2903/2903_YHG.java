import java.util.Scanner;

public class Problem_2903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double result = Math.pow(2, N);
		result = Math.pow(1+result, 2);
		System.out.println((long)result);
	}
}