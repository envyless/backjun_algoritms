import java.util.Scanner;

public class Problem_1834 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		long N = scn.nextLong();
		
		long sum = 0;

		for(int i = 1 ; i < N ; i++) 
			sum += (N*i + i);
		
		System.out.println(sum);
	}

}
