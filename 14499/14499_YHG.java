import java.io.*;
import java.util.StringTokenizer;

public class Problem_14499 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		int x = Integer.parseInt(st.nextToken()); // 세로
		int y = Integer.parseInt(st.nextToken()); // 가로
		int K = Integer.parseInt(st.nextToken()); 
		
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dice = new int[4][3];
		st = new StringTokenizer(br.readLine()," ");
		int move = 0;
		int tmp;
		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, -1, 1 };
		
		for(int i = 0 ; i < K ; i++) {
			move = Integer.parseInt(st.nextToken());
			int nextX = y + moveX[move-1];
			int nextY = x + moveY[move-1];
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;
			
			switch(move) {
			case 1:
				tmp = dice[1][1];
				dice[1][1] = dice[1][0];
				dice[1][0] = dice[3][1];
				dice[3][1] = dice[1][2];
				dice[1][2] = tmp;
				break;
			case 2:
				tmp = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = dice[3][1];
				dice[3][1] = dice[1][0];
				dice[1][0] = tmp;
				break;
			case 3:
				tmp = dice[1][1];
				dice[1][1] = dice[2][1];
				dice[2][1] = dice[3][1];
				dice[3][1] = dice[0][1];
				dice[0][1] = tmp;
				break;
			case 4:
				tmp = dice[1][1];
				dice[1][1] = dice[0][1];
				dice[0][1] = dice[3][1];
				dice[3][1] = dice[2][1];
				dice[2][1] = tmp;
				break;
			}
			
			if(map[nextY][nextX] == 0)
				map[nextY][nextX] = dice[3][1];
			else {
				dice[3][1] = map[nextY][nextX];
				map[nextY][nextX] = 0;
			}
			y = nextX;
			x = nextY;
			System.out.println(dice[1][1]);
		}
	}
}