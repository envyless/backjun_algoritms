import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_4179 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		boolean[][] check = new boolean[R][C];
		char[][] insert = new char[R][C];
		
		Queue<point_4179> peo = new LinkedList<point_4179>();
		Queue<point_4179> peoTmp = new LinkedList<point_4179>();
		Queue<point_4179> fire = new LinkedList<point_4179>();
		Queue<point_4179> fireTmp = new LinkedList<point_4179>();
		
		String tmp;
		for(int i = 0 ; i < R ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				insert[i][j] = tmp.charAt(j);
				if(insert[i][j] != '.')
					check[i][j] = true;
				if(insert[i][j] == 'J')
					peo.add(new point_4179(j,i,0));
				if(insert[i][j] == 'F')
					fire.add(new point_4179(j,i,0));
			}
		}
		
		int[] moveX = { 1, -1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };
		int min = 987654321;
		
		while(true) {
			
			while(!fire.isEmpty()) { // 불 부터 이동.
				point_4179 nowF = fire.poll();
				int nowFX = nowF.x;
				int nowFY = nowF.y;
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextFX = nowFX + moveX[i];
					int nextFY = nowFY + moveY[i];
					
					if(nextFX >= 0 && nextFY >= 0 && nextFY < R && nextFX < C && !check[nextFY][nextFX]) {
						check[nextFY][nextFX] = true;
						fireTmp.add(new point_4179(nextFX,nextFY, 0));
					}
				}
			}
			
			while(!peo.isEmpty()) {
				point_4179 now = peo.poll();
				int nowX = now.x;
				int nowY = now.y;
				
				if(nowX == 0 || nowY == 0 || nowX == C-1 || nowY == R-1) {
					if(min > now.c+1)
						min = now.c+1;
					continue;
				}
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = nowX + moveX[i];
					int nextY = nowY + moveY[i];
					
					if(nextX >= 0 && nextY >= 0 && nextY < R && nextX < C && !check[nextY][nextX]) {
						check[nextY][nextX] = true;
						peoTmp.add(new point_4179(nextX,nextY,now.c+1));
					}
				}
			}
			
			while(!peoTmp.isEmpty()) {
				point_4179 nowPT = peoTmp.poll();
				peo.add(new point_4179(nowPT.x,nowPT.y, nowPT.c));
			}
			
			while(!fireTmp.isEmpty()) {
				point_4179 nowFT = fireTmp.poll();
				fire.add(new point_4179(nowFT.x,nowFT.y, 0));
			}
			
			if(peo.isEmpty())
				break;
		}
		
		if(min == 987654321)
			System.out.println("IMPOSSIBLE ");
		else
			System.out.println(min);
	}
}
class point_4179{
	int x;
	int y;
	int c;
	
	public point_4179(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}