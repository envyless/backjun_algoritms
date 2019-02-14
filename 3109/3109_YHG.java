import java.io.*;
import java.util.StringTokenizer;

public class Problem_3109 {

	static int N;
	static int M;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		map = new char[N][M];
		
		String in;
		int len;
		for(int i = 0 ; i < N ; i++) {
			in = br.readLine();
			len = in.length();
			for(int j = 0 ; j < len ; j++)
				map[i][j] = in.charAt(j);
		}
		
		int count = 0;
		for(int i = 0 ; i < N ; i++)
			if(dfs(i,0))
				count++;
		System.out.println(count);
		
	}
	
	static public boolean dfs(int y, int x) {
		int move = -1;
		
		if(x == M-1) 
			return true;
		
		for(int i = 0 ; i < 3 ; i++) {
			int nextY = y + move++;
			
			if(nextY >= 0 && nextY < N && map[nextY][x+1] == '.') {
				map[nextY][x+1] = 'O';
				if(dfs(nextY,x+1))
					return true;
			}
		}
		return false;
	}
}