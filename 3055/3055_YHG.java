import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_3055 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken()); // 세로
		int C = Integer.parseInt(st.nextToken()); // 가로
		Queue<point_3055> water = new LinkedList<point_3055>();
		Queue<point_3055> s = new LinkedList<point_3055>();
		boolean[][] noWay = new boolean[R][C];
		boolean[][] rock = new boolean[R][C];
		boolean[][] visit = new boolean[R][C];
		int x = 0;
		int y = 0;
		int wCount = 0;
		int sCount = 0;
		
		String[] line = new String[R];
		char[][] insert = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			line[i] = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				insert[i][j] = line[i].charAt(j);
				char tmp = insert[i][j];
				if(tmp == 'D') {
					y = i;
					x = j;
				}else if(tmp == 'S') {
					s.add(new point_3055(i,j,0));
					visit[i][j] = true;
					sCount++;
				}else if(tmp == '*') {
					water.add(new point_3055(i,j,0));
					noWay[i][j] = true;
					wCount++;
				}else if(tmp == 'X')
					rock[i][j] = true;
			}
		}
		
		int[] moveX = {1,-1,0,0};
		int[] moveY = {0,0,1,-1};
		int time = 0;
		boolean finish = false;
		
		while(!water.isEmpty() || !s.isEmpty()) {
			
			int wTmp = 0;
			int sTmp = 0;
			
			while(wCount > 0) {
				wCount--;
				
				point_3055 nowWater = water.poll();
				int waterX = nowWater.x;
				int waterY = nowWater.y;
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = waterX + moveX[i];
					int nextY = waterY + moveY[i];
					
					if(nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
						if(rock[nextY][nextX] || noWay[nextY][nextX])
							continue;
						if(nextY == y && nextX == x)
							continue;
						
						noWay[nextY][nextX] = true;
						water.add(new point_3055(nextY, nextX,0));
						wTmp++;
					}
				}
			}
			wCount = wTmp;
			
			while(sCount > 0) {
				sCount--;
				
				point_3055 nowS = s.poll();
				int sX = nowS.x;
				int sY = nowS.y;
				int sC = nowS.count;
				
				if(time < sC)
					time = sC;
				if(sX == x && sY == y) {
					finish = true;
					break;
				}
				
				for(int i = 0 ; i < 4 ; i++) {
					int nextX = sX + moveX[i];
					int nextY = sY + moveY[i];
					
					if(nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
						if(rock[nextY][nextX] || noWay[nextY][nextX] || visit[nextY][nextX])
							continue;
						
						visit[nextY][nextX] = true;
						s.add(new point_3055(nextY, nextX,sC+1));
						sTmp++;
					}
				}
			}
			sCount = sTmp;
			
			if(finish)
				break;
		}
		
		if(!finish)
			System.out.println("KAKTUS");
		else
			System.out.println(time);
	}
}
class point_3055{
	int x;
	int y;
	int count;
	
	public point_3055(int y, int x, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}