import java.util.Scanner;

public class Problem_9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt();
		
		for(int TT = 0 ; TT < T ; TT++) {
			
			int N = scn.nextInt();
			long result = 0;
			
			if(N <= 3) {
				System.out.println(1);
				continue;
			}
			
			long[] insert = new long[N];
			insert[0] = 1;
			insert[1] = 1;
			insert[2] = 1;
			
			for(int i = 3; i < N ; i++)
				insert[i] = insert[i-2] + insert[i-3];
			
			System.out.println(insert[N-1]);
		}
	}
}