import java.io.*;
import java.util.StringTokenizer;

public class Problem_1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		
		char[][] insert = new char[N+1][M+1];
		String tmp;
		int count = 0;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			boolean check = false;
			for(int j = 0 ; j <= M ; j++) {
				if(j == M) {
					if(check)
						insert[i][j] = 'Y';
					continue;
				}
				char grd = tmp.charAt(j);
				if(grd == 'X')
					check = true;
				insert[i][j] = grd;
			}
		}
		
		for(int i = 0 ; i < M ; i++)
			for(int j = 0 ; j < N ; j++) {
				if(insert[j][i] == 'X') {
					insert[N][i] = 'Y';
					break;
				}
			}
		
		for(int i = 0 ; i < N ; i++) {
			boolean check = false;
			if(insert[i][M] == 'Y')
				continue;
			else {
				for(int j = 0 ; j < M ; j++) {
					if(insert[N][j] != 'Y') {
						count++;
						check = true;
						insert[N][j] = 'Y';
						insert[i][M] = 'Y';
						break;
					}
				}
				if(!check)
					count++;
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			boolean check = false;
			if(insert[N][i] == 'Y')
				continue;
			else {
				for(int j = 0 ; j < N ; j++) {
					if(insert[j][M] != 'Y') {
						count++;
						check = true;
						insert[N][j] = 'Y';
						insert[i][M] = 'Y';
						break;
					}
				}
				if(!check)
					count++;
			}
		}
		System.out.println(count);
	}
}