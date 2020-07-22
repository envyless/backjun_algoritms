import java.io.*;
import java.util.StringTokenizer;

public class Problem_9205 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int TT = Integer.parseInt(br.readLine());
		int max = 987654321;
		
		for(int T = 0 ; T < TT ; T++) {
			int c = Integer.parseInt(br.readLine());
			int[][] con = new int[c+2][2];
			for(int i = 0 ; i < c+2 ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dis = new int[c+2][c+2];
			boolean[] pos = new boolean[c+2];
			
			for(int i = 0 ; i < c+2 ; i++) {
				for(int j = 0 ; j < c+2 ; j++) {
					if(i == j) {
						dis[i][j] = max;
						continue;
					}
					dis[i][j] =  Math.abs(con[i][0] - con[j][0]) + Math.abs(con[i][1] - con[j][1]);
					if(dis[i][j] > 1000)
						dis[i][j] = max;
				}
			}
			for(int i = 0 ; i < c+2 ; i++) {
				if(dis[0][i] != max)
					pos[i] = true;
			}
			
			int count = 0;
			while(count < c+2) {
				
				for(int i = 0; i < c+2 ; i++) {
					if(!pos[i])
						continue;
					for(int j = 0 ; j < c+2 ; j++) {
						if(dis[i][j] != max) 
							pos[j] = true;
					}
				}
				count++;
			}
			
			if(pos[c+1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}