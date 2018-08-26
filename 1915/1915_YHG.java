import java.util.Scanner;

public class Problem_1915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] arr = new int[n+1][m+1]; // n За  m ї­
		int[][] len = new int[n+1][m+1];
		int length = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			String tmp = scn.next();
			for(int j = 1 ; j <= m ; j++) {
				arr[i][j] = tmp.charAt(j-1) - 48;
				if(arr[i][j] == 1) {
					int value = Math.min(len[i][j-1], Math.min(len[i-1][j], len[i-1][j-1]));
					arr[i][j] = value + 1;
					length = Math.max(length, arr[i][j]);
				}
				len[i][j] = arr[i][j];
			}
		}
		System.out.println(length*length);
	}
}