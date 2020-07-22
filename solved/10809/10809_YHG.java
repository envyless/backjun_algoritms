import java.util.Scanner;

public class Problem_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String line = scn.nextLine();
		int[] alpha = new int[26];
		for(int i = 0 ; i < 26 ; i++)
			alpha[i] = 200;
		
		for(int i = 0 ; i < line.length() ; i++) {
			char tmp = line.charAt(i);
			int index = tmp - 'a';
			if(alpha[index] == 200)
				alpha[index] = i;
		}
		
		for(int i = 0 ; i < 26 ; i++) {
			if(alpha[i] == 200)
				System.out.print(-1 + " ");
			else
				System.out.print(alpha[i] + " ");
		}
	}
}