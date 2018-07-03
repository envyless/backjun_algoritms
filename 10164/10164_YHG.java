import java.util.Scanner;

public class Problem_10164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 행. 세로
		int M = scn.nextInt(); // 열. 가로
		int K = scn.nextInt(); // 격자의 위치
		
		int[][] insert = new int[N][M];
		int count = 1;
		int[] save = new int[2];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				insert[i][j] = count++;
				if(K == insert[i][j]) {
					save[0] = i; // 세로
					save[1] = j; // 가로
				}
			}
		}
		
		// 격자가 없을 경우 최단거리로 갈 수 있는 모든 경우의 수를 출력
		if( K == 0 ) {
			double top = 1;
			double bottom = 1;
			int tmp1, tmp2;
			long result;
			
			if(N == 1 || M == 1) {
				result = 1;
			}
			else {
				
				if(N > M) { tmp1 = N-1; tmp2 = M-1; }
				else { tmp1 = M-1; tmp2 = N-1; }
				
				for(int i = 1+tmp1 ; i <= tmp1+tmp2 ; i++)
					top *= i;
				
				for(int i = 1 ; i <= tmp2 ; i++)
					bottom *= i;
				
				result = (long)(top / bottom);
			}
			
			System.out.println(result);
		}
		// 격자가 있을 경우. 해당 격자를 반드시 지나야 한다.
		// 로봇은 오른쪽 혹은 아래로만 이동이 가능하다.
		else {
			double[] top = new double[2];
			double[] bottom = new double[2];
			long[] result = new long[2];
			
			int tmp1, tmp2;
			
			for(int i = 0 ; i < 2 ; i++) {
				top[i] = 1;
				bottom[i] = 1;
			}
			
			
			if(save[0] > save[1]) { tmp1 = save[0]; tmp2 = save[1]; }
			else { tmp1 = save[1]; tmp2 = save[0]; }
			
			for(int i = 1+tmp1 ; i <= tmp1 + tmp2 ; i++)
				top[0] *= i;
			
			for(int i = 1 ; i <= tmp2 ; i++)
				bottom[0] *= i;
			
			
			result[0] = (long)(top[0] / bottom[0]);
			
			int tmpY = N - (save[0]+1);
			int tmpX = M - (save[1]+1);
			
			
			if(tmpY > tmpX) { tmp1 = tmpY; tmp2 = tmpX; }
			else { tmp1 = tmpX; tmp2 = tmpY; }
			
			for(int i = 1+tmp1 ; i <= tmpY + tmpX ; i++)
				top[1] *= i;
			
			for(int i = 1 ; i <= tmp2 ; i++)
				bottom[1] *= i;
			
			
			result[1] = (long)(top[1] / bottom[1] );
			
			System.out.println(result[0] * result[1]);
		}	
	}
}