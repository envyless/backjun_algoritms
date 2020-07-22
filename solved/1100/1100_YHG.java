import java.io.*;

public class Problem_1100 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		boolean[][] CF = new boolean[8][8];
		char[][] insert = new char[8][8];
		
		for(int i = 0 ; i < 8 ; i ++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < 8 ; j++)
				insert[i][j] = tmp.charAt(j);
		}
		
		CF[0][0] = true;
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				if(i == 0 && j == 0)
					continue;
				if(j == 0) {
					if(CF[i-1][0])
						CF[i][0] = false;
					else
						CF[i][0] = true;
					continue;
				}
				if(CF[i][j-1])
					CF[i][j] = false;
				else
					CF[i][j] = true;
			}
		}
		
		int count = 0;
		
		for(int i = 0 ; i < 8 ; i++)
			for(int j = 0 ; j < 8 ; j++)
				if(CF[i][j] && insert[i][j] == 'F')
					count++;
		System.out.println(count);
		
	}
}