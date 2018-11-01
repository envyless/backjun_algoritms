import java.io.*;
import java.util.StringTokenizer;

public class Problem_14891 {
	
	static int[][] insert = new int[4][8];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;

		for(int i = 0 ; i < 4 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < 8 ; j++)
				insert[i][j] = tmp.charAt(j) - '0';
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int spin = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[4];
			
			turn(num,spin,check);
		}
		int score = insert[0][0] * 1 + insert[1][0] * 2 + insert[2][0] * 4 + insert[3][0] * 8;
		System.out.println(score);
	}
	
	static public void turn(int num, int spin, boolean[] check) {
		check[num] = true;
		int[] tmp = new int[8];
		for(int i = 0 ; i < 8 ; i++) 
			tmp[i] = insert[num][i];
		
		// 회전
		if(spin == 1) { // 시계방향
			for(int i = 0 ; i < 8 ; i++) {
				if(i == 0)
					insert[num][i] = tmp[7];
				else
					insert[num][i] = tmp[i-1];
			}
		}
		else {
			for(int i = 0 ; i < 8 ; i++) {
				if(i == 7)
					insert[num][i] = tmp[0];
				else
					insert[num][i] = tmp[i+1];
			}
		}
		
		if(num+1 <= 3)
			if(!check[num+1]) {
				if(spin == 1) {
					if(insert[num][3] != insert[num+1][6])
						turn(num+1, -1, check);
				}
				else {
					if(insert[num][1] != insert[num+1][6])
						turn(num+1, 1, check);
				}
			}
		if(num-1 >= 0)
			if(!check[num-1]) {
				if(spin == 1) {
					if(insert[num][7] != insert[num-1][2])
						turn(num-1, -1, check);
				}
				else {
					if(insert[num][5] != insert[num-1][2]) 
						turn(num-1, 1, check);
				}
			}			
	}
}