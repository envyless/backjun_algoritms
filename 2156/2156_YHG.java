import java.util.Scanner;
public class Problem_2156 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt(); 
		int[] grp = new int[N+1];
		int[] sum = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++)
			grp[i] = scn.nextInt();
		
		if(N == 1)
			System.out.println(grp[1]);
		else if(N == 2)
			System.out.println(grp[1] + grp[2]);
		else {
			sum[1] = grp[1];
			sum[2] = grp[1] + grp[2];
			
			for(int i = 3 ; i < N+1 ; i++) {
				sum[i] = Integer.max( Integer.max(sum[i-1], sum[i-2] + grp[i]), sum[i-3] + grp[i] + grp[i-1]);
			}
			
			int max = 0;
			for(int i = 1 ; i < N+1 ; i++) {
				max = Integer.max(max, sum[i]);
			}
			
			System.out.println(max);
		}
	}
}