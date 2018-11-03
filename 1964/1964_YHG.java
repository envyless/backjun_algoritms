import java.util.Scanner;

public class Problem_1964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int div = 45678;
		long point = 5;
		
		for(int i = 2 ; i <= N ; i++)
			point += (i+1)*3 - 2;
		
		point %= div;
		System.out.println(point);
	}
}