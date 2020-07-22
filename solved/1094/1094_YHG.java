import java.util.Scanner;

public class Problem_1094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int start = 64;
		if(N == start) {
			System.out.println(1);
			return ;
		}
		
		int[] save = new int[8];
		int index = 0;
		save[0] = start;
		
		while(start > 1) {
			int tmp = start/2;
			save[index] = tmp;
			int sum = 0;
			for(int i = 0 ; i <= index ; i++)
				sum += save[i];
			if(sum < N)
				save[++index] = tmp;
			start = tmp;
			
			int count = 0;
			sum = 0;
			for(int i = 0 ; i < 8 ; i++) {
				sum += save[i];
				count++;
				if(sum == N) {
					System.out.println(count);
					return ;
				}
			}
		}
	}
}