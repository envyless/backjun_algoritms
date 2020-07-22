import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_12761 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken()); // A나 A배
		int B = Integer.parseInt(st.nextToken()); // B나 B배
		int N = Integer.parseInt(st.nextToken()); // N > M 으로 이동
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[100001];
		
		Queue<point_12761> q = new LinkedList<point_12761>();
		q.add(new point_12761(N,0));
		check[N] = true;
		int[] move = { 1, A, B};
		
		while(!q.isEmpty()) {
			point_12761 now = q.poll();
			int nowX = now.x;
			if(nowX == M) {
				System.out.println(now.c);
				break;
			}
			
			for(int i = 0 ; i < 3 ; i++) {
				int nextX = now.x + move[i];
				int nextXn = now.x - move[i];
				
				if(nextX >= 0 && nextX <= 100000 && !check[nextX]) {
					check[nextX] = true;
					q.add(new point_12761(nextX, now.c+1));
				}
				
				if(nextXn >= 0 && nextXn <= 100000 && !check[nextXn]) {
					check[nextXn] = true;
					q.add(new point_12761(nextXn, now.c+1));
				}
			}
			
			for(int i = 1 ; i < 3 ; i++) {
				int nextX = now.x * move[i];
				int nextXn = now.x - (now.x * move[i]);
				
				if(nextX >= 0 && nextX <= 100000 && !check[nextX]) {
					check[nextX] = true;
					q.add(new point_12761(nextX, now.c+1));
				}
				
				if(nextXn >= 0 && nextXn <= 100000 && !check[nextXn]) {
					check[nextXn] = true;
					q.add(new point_12761(nextXn, now.c+1));
				}
			}
		}
	}
}
class point_12761{
	int x;
	int c;
	
	public point_12761(int x, int c) {
		this.x = x;
		this.c = c;
	}
}