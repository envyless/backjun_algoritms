import java.util.Scanner;

public class Problem_2096 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		
		int[] insert = new int[3];
		int[] save = new int[6];
		
		for(int i = 0 ; i < 6 ; i++)
			save[i] = 0;
		
		for(int i = 0 ; i < N ; i++) {
			insert[0] = scn.nextInt();
			insert[1] = scn.nextInt();
			insert[2] = scn.nextInt();
			
			int min0 = Integer.min(save[0], save[2]) + insert[0];
			int max0 = Integer.max(save[1], save[3]) + insert[0];
			
			int min1 = Integer.min(Integer.min(save[0], save[2]) , save[4]) + insert[1];
			int max1 = Integer.max(Integer.max(save[1], save[3]) , save[5]) + insert[1];
			
			int min2 = Integer.min(save[2], save[4]) + insert[2];
			int max2 = Integer.max(save[3], save[5]) + insert[2];
			
			save[0] = min0;
			save[1] = max0;
			
			save[2] = min1;
			save[3] = max1;
			
			save[4] = min2;
			save[5] = max2;
			
		}
		
		int min = save[0];
		int max = save[1];
		for(int i = 2 ; i < 6 ; i +=2) {
			if(min > save[i]) min = save[i];
			if(max < save[i+1]) max = save[i+1];
		}
		
		System.out.println(max + " " + min);
	}
}
