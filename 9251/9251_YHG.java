import java.util.Scanner;

public class Problem_9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String first = " " + scn.next();
		String second = " " + scn.next();
		
		int lenF = first.length();
		int lenS = second.length();
		
		int[][] count = new int[lenS][lenF];

		
		for (int i = 1; i < lenS; i++) {
			for (int j = 1; j < lenF; j++) {
				if (second.charAt(i) == first.charAt(j)) { 
					count[i][j] = count[i - 1][j - 1] + 1;
				}
				else { 
					count[i][j] = Math.max(count[i - 1][j], count[i][j - 1]);
				}
			}
		}
		System.out.println(count[lenS - 1][lenF - 1]);
	}
}