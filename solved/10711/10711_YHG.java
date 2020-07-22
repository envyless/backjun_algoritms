import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_10711 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // ga
		int M = Integer.parseInt(st.nextToken()); // se
		
		Queue<point_10711>[] q = new LinkedList[2];
		q[0] = new LinkedList<point_10711>();
		q[1] = new LinkedList<point_10711>();
		
		char[][] insert = new char[N][M];
		String tmp;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = tmp.charAt(j);
		}
		
		int re = 0;
		
		int[] checkX = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int[] checkY = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[][] sand = new int[N][M];
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++) {
				for(int z = 0 ; z < 8 ; z++) {
					int nextX = j + checkX[z];
					int nextY = i + checkY[z];
					
					if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && insert[nextY][nextX] == '.')
						sand[i][j]++;
				}
				if(insert[i][j] != '.' && insert[i][j] - '0' <= sand[i][j])
					q[0].add(new point_10711(j,i));
			}
		
		int value = 0;
		while(!q[value%2].isEmpty()) {
			while(!q[value%2].isEmpty()) {
				point_10711 now = q[value%2].poll();
				int x = now.x;
				int y = now.y;
				for(int z = 0 ; z < 8 ; z++) {
					int nextX = x + checkX[z];
					int nextY = y + checkY[z];
					
					if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && insert[nextY][nextX] != '.')
						sand[nextY][nextX]++;
					
					if(insert[nextY][nextX] != '.' && insert[nextY][nextX] - '0' == sand[nextY][nextX])
						q[(value+1)%2].add(new point_10711(nextX,nextY));
				}
			}
			
			re++;
			value = (value+1)%2;
		}
		System.out.println(re);
	}
}
class point_10711{
	int x;
	int y;
	
	public point_10711(int x, int y) {
		this.x = x;
		this.y = y;
	}
}