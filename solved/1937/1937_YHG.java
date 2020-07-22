import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int[][] insert = new int[N][N];
		PriorityQueue<Index> q = new PriorityQueue<Index>(new ASC());
		
		int[][] days = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				insert[i][j] = scn.nextInt();
				q.add(new Index(i,j, insert[i][j]));
				days[i][j] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			Index tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			int[] calX = { -1, 1, 0, 0 };
			int[] calY = { 0, 0, -1, 1 };
			
			for(int i = 0 ; i < 4 ; i++) {
				int tmpX = x + calX[i];
				int tmpY = y + calY[i];
				
				if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < N) {
					if(insert[tmpY][tmpX] > insert[y][x]) {
						if(days[tmpY][tmpX] < days[y][x] + 1)
							days[tmpY][tmpX] = days[y][x] + 1;
					}
				}
			}
		}
		
		int max = days[0][0];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(max < days[i][j])
					max = days[i][j];
			}
		}
		
		System.out.println(max);
	}
}

class Index{
	int x;
	int y;
	int value;
	
	public Index(int y,int x, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
}

class ASC implements Comparator<Index>{
	
	public int compare(Index v1, Index v2) {
        return v1.value < v2.value ? -1 : 1;
    }
}
