import java.util.Scanner;

public class Problem_1003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // Å×½ºÆ® °¹¼ö
		int[] N = new int[T];
		
		for(int i = 0 ; i < T ; i++)
			N[i] = scn.nextInt();
		
		int[][] save = new int[41][2];
		
		save[0][0] = 1; save[0][1] = 0;
		save[1][0] = 0; save[1][1] = 1;
		save[2][0] = 1; save[2][1] = 1;
		
		for(int i = 0 ; i < T ; i++) {
			if(N[i] < 3) 
				System.out.println(save[N[i]][0] + " " + save[N[i]][1]);
			else {
				for(int j = 3 ; j <= N[i] ; j++) {
					save[j][0] = save[j-1][0] + save[j-2][0];
					save[j][1] = save[j-1][1] + save[j-2][1];
				}
				System.out.println(save[N[i]][0] + " " + save[N[i]][1]);
			}
		}
	}
}