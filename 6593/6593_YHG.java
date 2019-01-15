import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Problem_6593 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		String tmp;
		Queue<people_6593> q = new LinkedList<people_6593>();
		
		int[] moveF = { -1, 1, 0, 0, 0, 0 };
		int[] moveC = { 0, 0, -1, 1, 0, 0 };
		int[] moveR = { 0, 0, 0, 0, -1, 1 };
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0)
				break;
			
			int min = 0;
			char[][][] insert = new char[L][R][C];
			boolean[][][] visit = new boolean[L][R][C];
			int[] start = new int[3];
			int[] end = new int[3];
			
			for(int i = 0 ; i < L ; i++)
				for(int j = 0 ; j < R ; j++) 
					for(int k = 0 ; k < C ; k++)
						visit[i][j][k] = false;
			
			for(int i = 0 ; i < L ; i++) {
				for(int j = 0 ; j < R ; j++) {
					tmp = br.readLine();
					for(int k = 0 ; k < C ; k++) {
						insert[i][j][k] = tmp.charAt(k);
						if(insert[i][j][k] == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = k;
						}
						if(insert[i][j][k] == 'E') {
							end[0] = i;
							end[1] = j;
							end[2] = k;
						}
						if(insert[i][j][k] == '#')
							visit[i][j][k] = true;
					}
				}
				br.readLine();
			}
			
			q.add(new people_6593(start[0], start[1], start[2], 0));
			visit[start[0]][start[1]][start[2]] = true;
			
			while(!q.isEmpty()) {
				people_6593 now = q.poll();
				int nowF = now.f;
				int nowC = now.c;
				int nowR = now.r;
				int nowT = now.time;
				
				if(nowF == end[0] && nowC == end[1] && nowR == end[2]) {
					if(min == 0)
						min = nowT;
					if(min > nowT)
						min = nowT;
					continue;
				}
				
				for(int i = 0 ; i < 6 ; i++) {
					int nextF = nowF + moveF[i];
					int nextC = nowC + moveC[i];
					int nextR = nowR + moveR[i];
					
					if(nextF >= 0 && nextC >= 0 && nextR >= 0 && nextF < L && nextC < R && nextR < C && !visit[nextF][nextC][nextR]) {
						q.add(new people_6593(nextF, nextC, nextR, nowT+1));
						visit[nextF][nextC][nextR] = true;
					}
				}
			}
			
			if(min == 0)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in " + min + " minute(s).");
		}
	}
}

class people_6593{
	int f;
	int c;
	int r;
	int time;
	
	public people_6593(int x, int y, int z, int time) {
		this.f = x;
		this.c = y;
		this.r = z;
		this.time = time;
	}
}