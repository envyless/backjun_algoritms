import java.io.*;
import java.util.StringTokenizer;

public class Problem_1063 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String king = st.nextToken();
		String stn = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		char x = king.charAt(0);
		char y = king.charAt(1);
		char sx = stn.charAt(0);
		char sy = stn.charAt(1);
		
		String tmp = "";
		char insert;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			insert = tmp.charAt(0);
			int moveX = 0;
			int moveY = 0;
			
			if(insert == 'R') {
				moveX = 1;
			}else if(insert == 'L') {
				moveX = -1;
			}else if(insert == 'T') {
				moveY = 1;
			}else {
				moveY = -1;
			}
			
			if(tmp.length() == 2) {
				insert = tmp.charAt(1);
				if(insert == 'T') {
					moveY = 1;
				}else {
					moveY = -1;
				}
			}
			x += moveX;
			y += moveY;
			if(x < 'A' || y < '1' || x > 'H' || y > '8') {
				x -= moveX;
				y -= moveY;
				continue;
			}
			
			if(x == sx && y == sy) {
				sx += moveX;
				sy += moveY;
				if(sx < 'A' || sy < '1' || sx > 'H' || sy > '8') {
					sx -= moveX;
					sy -= moveY;
					x -= moveX;
					y -= moveY;
					continue;
				}
			}
		}
		System.out.println(x+""+y);
		System.out.println(sx+""+sy);
	}
}