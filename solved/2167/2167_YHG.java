import java.util.Scanner;

public class Problem_2167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // За : y
		int m = scn.nextInt(); // ї­ : x
		int[][] insert = new int[n][m];
		
		for(int i = 0; i < n ; i++)
			for(int j = 0 ; j < m ; j++)
				insert[i][j] = scn.nextInt();
		
		int k = scn.nextInt();
		int[] tmp = new int[4];
				
		for(int TC = 0 ; TC < k ; TC++) {
			for(int i = 0 ; i < 4 ; i++)
				tmp[i] = scn.nextInt() - 1;
	
			int result = 0;
			for(int i = tmp[0] ; i <= tmp[2] ; i++)
				for(int j = tmp[1] ; j <= tmp[3]; j++)
					result += insert[i][j];
			
			System.out.println(result);	
		}	
	}
}