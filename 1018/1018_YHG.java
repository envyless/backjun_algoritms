import java.io.*;
import java.util.StringTokenizer;

public class Problem_1018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] insert = new char[N][M];
		
		String tmp;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = tmp.charAt(j);
		}
		
		char[][] start ={ { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
						{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'} };
		
		int minB, minW;
		int min = 987654321;
		char save;
		for(int i = 0 ; i <= N-8 ; i++) { // Y start index
			for(int j = 0 ; j <= M-8 ; j++) { // X start index
				minB = 0;
				minW = 0;
				
				for(int y = i ; y < i+8 ; y++) {
					for(int x = j ; x < j+8 ; x++) {
						save = insert[y][x];
						if(start[y%2][x%8] != save)
							minB++;
						if(start[(y+1)%2][x%8] != save)
							minW++;
					}
				}
				
				if(min > minB || min > minW)
					min = minB < minW ? minB : minW;
			}
		}
		System.out.println(min);
	}
}