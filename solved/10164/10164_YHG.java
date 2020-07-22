import java.util.Scanner;

public class Problem_10164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ��. ����
		int M = scn.nextInt(); // ��. ����
		int K = scn.nextInt(); // ������ ��ġ
		
		int[][] insert = new int[N][M];
		int count = 1;
		int[] save = new int[2];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				insert[i][j] = count++;
				if(K == insert[i][j]) {
					save[0] = i; // ����
					save[1] = j; // ����
				}
			}
		}
		
		// ���ڰ� ���� ��� �ִܰŸ��� �� �� �ִ� ��� ����� ���� ���
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
		// ���ڰ� ���� ���. �ش� ���ڸ� �ݵ�� ������ �Ѵ�.
		// �κ��� ������ Ȥ�� �Ʒ��θ� �̵��� �����ϴ�.
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