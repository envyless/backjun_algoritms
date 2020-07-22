import java.util.Scanner;

public class Problem_1495 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // �� ����
		int S = scn.nextInt(); // ���� ����
		int M = scn.nextInt(); // �ִ� ����
		// ������ ���� ������ ��, ������ �ִ� ������ ?
		int[] vol = new int[N];
		for(int i = 0 ; i < N ; i++)
			vol[i] = scn.nextInt();
		
		boolean[][] dp = new boolean[N][M+1];
		
		int noMove = 0;
		
		if(S + vol[0] <= M)
			dp[0][S + vol[0]] = true;
		else
			noMove++;
		
		if(S - vol[0] >= 0)
			dp[0][S - vol[0]] = true;
		else
			noMove++;
		
		if(noMove == 2) {
			System.out.println(-1);
			return ;
		}
		noMove = 0;
		
		for(int i = 1 ; i < N ; i++) {
			int moveVol = vol[i];
			int noMoveCount = 0;
			int insertCount = 0;
			
			for(int j = 0 ; j <= M ; j++) {
				if(dp[i-1][j]) {
					insertCount++;
					if(j + moveVol <= M)
						dp[i][j + moveVol] = true;
					else
						noMove++;
					
					if(j - moveVol >= 0)
						dp[i][j - moveVol] = true;
					else
						noMove++;
					
					if(noMove == 2)
						noMoveCount++;
					noMove = 0;
				}
			}
			if(insertCount == noMoveCount) {
				System.out.println(-1);
				return ;
			}
		}
		int max = 0;
		for(int i = M ; i >= 0 ; i--)
			if(dp[N-1][i]) {
				max = i;
				break;
			}
		
		System.out.println(max);
	}
}