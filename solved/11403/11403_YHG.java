import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_11403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정점의 수
		boolean[][] insert = new boolean[N][N];
		Queue<Link_11403> q = new LinkedList<Link_11403>();
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				if(scn.nextInt() == 1)
					insert[i][j] = true;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(insert[i][j])
					q.add(new Link_11403(i,j));
				
				while(!q.isEmpty()) {
					Link_11403 link = q.poll();
					int start = link.start;
					int end = link.end;
					
					for(int k = 0 ; k < N ; k++)
						if(insert[end][k]) {
							if(insert[start][k])
								continue;
							insert[start][k] = true;
							q.add(new Link_11403(start, k));
						}
				}
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++)
				if(insert[i][j])
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			System.out.println();
		}
	}

}

class Link_11403{
	int start;
	int end;
	
	public Link_11403(int x, int y) {
		this.start = x;
		this.end = y;
	}
}