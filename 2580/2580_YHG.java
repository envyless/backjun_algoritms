import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Problem_2580 {

	static LinkedList<point_2580> ll = new LinkedList<point_2580>();
	static int[][] insert = new int[9][9];
	static int size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < 9 ; j++) {
				insert[i][j] = Integer.parseInt(st.nextToken());
				if(insert[i][j] == 0)
					ll.add(new point_2580(i,j));
			}
		}
		
		input(0);
	}
	
	static public boolean input(int c) {
		if(ll.size() == c) {
			print();
			return true;
		}
		
		int x = ll.get(c).x;
		int y = ll.get(c).y;
		for(int n = 1; n < 10; n++) {
			if(check(x,y,n)) {
				insert[x][y] = n;
				if(input(c+1))
					return true;
				insert[x][y] = 0;
			}
		}
		
		return false;
	}
	
	static public boolean check(int x, int y, int n) {
		boolean clear = true;
		for (int i = 0; i < 9; i++)
			if (insert[x][i] == n) {
				clear = false;
				break;
			}
		
		for (int i = 0; i < 9; i++)
			if(insert[i][y] == n) {
				clear = false;
				break;
			}
		
		int sx = x / 3 * 3;
		int sy = y / 3 * 3;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(insert[i+sx][j+sy] == n) {
					clear = false;
					break;
				}
		
		if(clear)
			return true;
		return false;
	}
	
	static public void print() {
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ;j++)
				System.out.print(insert[i][j] + " ");
			System.out.println();
		}
	}
}

class point_2580{
	int x;
	int y;
	
	public point_2580(int x, int y) {
		this.x = x;
		this.y = y;
	}
}