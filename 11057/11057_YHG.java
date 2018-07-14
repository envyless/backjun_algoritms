import java.util.Scanner;

public class Problem_11057 {
	
	static int mod = 10007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ����
		
		int[] dp = new int[10];
		int result = 0;
		
		for (int i = 0; i < 10; i++) 
			dp[i] = 1;
		
		// N�� 1�� ���� ���ٸ� ������ �ʿ����� ����.
		if(N == 1)
			System.out.println(10);
		else {
			
			for (int i = 1; i < N; i++) {
				result = 0;
				
				for (int j = 1; j < 10; j++) {
					dp[j] = (dp[j] + dp[j - 1]) % mod;
					result = (result + dp[j]) % mod;
				}
			}
			result++; // N�ڸ��� ��� ���� 0�� ��쵵 ����.
			System.out.println(result % mod);
		}
	}
}