import java.io.*;
import java.util.StringTokenizer;

public class Problem_14889 {

	static int min = 987654321;
	static int N;
	static int[][] insert;
	static int[] cho;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		insert = new int[N][N];
		cho = new int[N/2];
		boolean[] visit = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++)
				insert[i][j] = Integer.parseInt(st.nextToken());
		}
		
		search(visit,0,0);
		
		System.out.println(min);
	}
	
	static public void search(boolean[] visit, int point, int len) {
		if(point >= N)
			return;
		if(len == N/2) {
			int value1 = 0;
			int value2 = 0;
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++) {
					if(i == j)
						continue;
					if(visit[i] && visit[j])
						value1 += insert[i][j];
				}
			
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++) {
					if(i == j)
						continue;
					if(!visit[i] && !visit[j])
						value2 += insert[i][j];
				}

			
			if(min > Math.abs(value1 - value2))
				min = Math.abs(value1 - value2);
			return;
		}
		
		visit[point] = true;
		search(visit, point+1, len+1);
		visit[point] = false;
		search(visit, point+1, len);
	}
}