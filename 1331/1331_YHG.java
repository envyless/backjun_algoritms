import java.io.*;

public class Problem_1331 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		boolean[][] ch = new boolean[6][6];
		String tmp = br.readLine();
		int x = tmp.charAt(0) - 'A';
		int y = tmp.charAt(1) - '0' -1;
		ch[y][x] = true;
		
		int startX = x;
		int startY = y;
		int[] moveX = { 1, -1, 1, -1, 2, -2, 2, -2 };
		int[] moveY = { 2, 2, -2, -2, 1, 1, -1, -1 };
		boolean check = false;
		
		for(int T = 0 ; T < 35 ; T++) {
			tmp = br.readLine();
			int nextX = tmp.charAt(0) - 'A';
			int nextY = tmp.charAt(1) - '0' -1;
			check = false;
			
			for(int i = 0 ; i < 8 ; i++) {
				int tmpX = x + moveX[i];
				int tmpY = y + moveY[i];
				
				if(tmpX == nextX && tmpY == nextY) {
					check = true;
					break;
				}
			}
			
			if(!check || ch[nextY][nextX]) {
				check = false;
				break;
			}
			
			ch[nextY][nextX] = true;
			x = nextX;
			y = nextY;
		}
		
		if(!check) {
			System.out.println("Invalid");
			return;
		}
		
		check = false;
		for(int i = 0 ; i < 8 ; i++) {
			int tmpX = x + moveX[i];
			int tmpY = y + moveY[i];
			
			if(tmpX == startX && tmpY == startY) {
				check = true;
				break;
			}
		}
		
		if(!check)
			System.out.println("Invalid");
		else
			System.out.println("Valid");
	}
}