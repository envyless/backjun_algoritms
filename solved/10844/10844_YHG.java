import java.util.Scanner;

public class Problem_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 자연수 길이
		long[][] insert = new long[N][10];
		long div = 1000000000;
		long sum = 0;
		
		for(int i = 1 ; i < 10 ; i++)
			insert[0][i] = 1;
		insert[0][0] = 0;
		
		for(int i = 1; i < N ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				long tmp = 0;
				
				if(j+1 < 10)
					tmp += insert[i-1][j+1];
				if(j-1 >= 0)
					tmp += insert[i-1][j-1];
				
				insert[i][j] = tmp % div;
			}
		}
		
		for(int i = 0 ; i < 10 ; i++)
			sum = (sum + insert[N-1][i]) % div;
		
		System.out.println(sum);
	}
}
