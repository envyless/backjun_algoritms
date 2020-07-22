import java.util.Arrays;
import java.util.Scanner;

public class Problem_2997 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int[] insert = new int[3];
		
		for(int i = 0 ; i < 3 ; i++)
			insert[i] = scn.nextInt();
		
		Arrays.sort(insert);
		int dif = 1000;
		
		for(int i = 0 ; i < 2 ; i++) {
			int tmp = insert[i+1] - insert[i];
			tmp = Math.abs(tmp); 
			if(tmp < dif)
				dif = tmp;
		}
		
		boolean check = false;
		
		for(int i = 0 ; i < 2 ; i++) {
			int tmp = insert[i+1] - insert[i];
			tmp = Math.abs(tmp);
			if(tmp == dif)
				continue;
			else {
				check = true;
				System.out.println(insert[i] + dif);
			}
		}
		if(!check)
			System.out.println(insert[2] + dif);
	}
}