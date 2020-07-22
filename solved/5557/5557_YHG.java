import java.util.Scanner;

public class Problem_5557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // ������ ����
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		// ������ ����� 0�̻� 20������ ��.
		long[][] dp = new long[N][21];
		dp[0][insert[0]] = 1;
		
		for(int i = 1 ; i < N-1 ; i++) { // N�� �����
			
			for(int j = 0 ; j < 21 ; j++) {
				if(dp[i-1][j] > 0) {
					if(j + insert[i] < 21) 
						dp[i][j + insert[i]] += dp[i-1][j];
					
					if(j - insert[i] >= 0) 
						dp[i][j - insert[i]] += dp[i-1][j];
					
				}
			}
			
		}
		
		int result = insert[N-1];
		System.out.println(dp[N-2][result]);
	}
}