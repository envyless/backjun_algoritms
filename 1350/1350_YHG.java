import java.util.Scanner;

public class Problem_1350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		long[] F = new long[N];
		long count = 0;
		
		for(int i = 0 ; i < N ; i++)
			F[i] = scn.nextLong();
		
		long C = scn.nextLong();
		
		for(int i = 0 ; i < N ; i++) {
			if(F[i] > C) {
				long tmp = F[i] / C;
				long tmp2 = F[i] % C;
				count += tmp;
				if(tmp2 != 0)
					count++;
			}else {
				if(F[i] != 0)
					count++;
			}
		}
	
		System.out.println(count * C);
	}

}
