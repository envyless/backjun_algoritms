import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); 
		int M = scn.nextInt();
		scn.nextLine();
		
		int[][] insert = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		int[][] length = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String str = scn.nextLine();
			for(int j = 0 ; j < M ; j++)
				insert[i][j] = str.charAt(j) - 48;
		}
		
		Queue<Integer> indexX = new LinkedList<Integer>();
		Queue<Integer> indexY = new LinkedList<Integer>();
		
		indexX.add(0);
		indexY.add(0);
		visit[0][0] = true;
		length[0][0] = 1;
		
		while(!indexX.isEmpty()) {
			int x = indexX.poll();
			int y = indexY.poll();
			
			if(x == N-1 && y == M-1) {
				System.out.println(length[x][y]);
				break;
			}
			
			if(x+1 < N && !visit[x+1][y] && insert[x+1][y] == 1) {
				visit[x+1][y] = true;
				indexX.add(x+1);
				indexY.add(y);
				if(length[x+1][y] == 0)
					length[x+1][y] = length[x][y] + 1;
				else
					if(length[x+1][y] > length[x][y] + 1)
						length[x+1][y] = length[x][y] + 1;
			}
			
			if(y+1 < M && !visit[x][y+1] && insert[x][y+1] == 1) {
				visit[x][y+1] = true;
				indexX.add(x);
				indexY.add(y+1);
				if(length[x][y+1] == 0)
					length[x][y+1] = length[x][y] + 1;
				else
					if(length[x][y+1] > length[x][y] + 1)
						length[x][y+1] = length[x][y] + 1;
			}
			
			if( x-1 >= 0 && !visit[x-1][y] && insert[x-1][y] == 1) {
				visit[x-1][y] = true;
				indexX.add(x-1);
				indexY.add(y);
				if(length[x-1][y] == 0)
					length[x-1][y] = length[x][y] + 1;
				else
					if(length[x-1][y] > length[x][y] + 1)
						length[x-1][y] = length[x][y] + 1;
			}
			
			if(y-1 >= 0 && !visit[x][y-1] && insert[x][y-1] == 1) {
				visit[x][y-1] = true;
				indexX.add(x);
				indexY.add(y-1);
				if(length[x][y-1] == 0)
					length[x][y-1] = length[x][y] + 1;
				else
					if(length[x][y-1] > length[x][y] + 1)
						length[x][y-1] = length[x][y] + 1;
			}		
		}
	}
}