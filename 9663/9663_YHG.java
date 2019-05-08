import java.io.*;

public class Problem_9663 {

	static int count = 0;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			line[0] = i;
			dfs(line, 0);
		}
		System.out.println(count);
	}
	
	public static void dfs(int[] line, int row) {
		
		if(row == N-1) {
			count++;
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			line[row+1] = i;
			if(check(line,row+1))
				dfs(line,row+1);
		}
	}
	
	public static boolean check(int[] line, int row) {
		for(int i = 0 ; i < row ; i++)
			if(line[row] == line[i] || Math.abs(row - i) == Math.abs(line[row] - line[i]))
				return false;
		return true;
	}
}