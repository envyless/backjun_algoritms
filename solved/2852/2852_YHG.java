import java.io.*;
import java.util.StringTokenizer;

public class Problem_2852 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String[][] insert = new String[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			insert[i][0] = st.nextToken();
			insert[i][1] = st.nextToken();
		}
		
		int[][] result = new int[N+1][4];
		boolean[] check = new boolean[3];
		int[] time = new int[2];
		
		int[] win = new int[4];
		int tmp = 0;
		int shot = 0;
		for(int i = 1 ; i <= N ; i++) {
			result[i][0] = (insert[i-1][1].charAt(0) - '0') * 10 + (insert[i-1][1].charAt(1) - '0');
			result[i][1] = (insert[i-1][1].charAt(3) - '0') * 10 + (insert[i-1][1].charAt(4) - '0');
			shot = Integer.parseInt(insert[i-1][0]);
			if(shot == 1) {
				result[i][2] = result[i-1][2] + 1;
				result[i][3] = result[i-1][3];
			}
			else if(shot == 2){
				result[i][2] = result[i-1][2];
				result[i][3] = result[i-1][3] + 1;
			}
			
			if(!check[1] && !check[2]) {
				check[shot] = true;
				time[0] = result[i][0];
				time[1] = result[i][1];
				continue;
			}
			
			if(result[i][2] == result[i][3]) {
				if(check[1])
					tmp = 0;
				else if(check[2])
					tmp = 2;
				
				win[0+tmp] += (result[i][0] - time[0]);
				win[1+tmp] += (result[i][1] - time[1]);
				if(win[1+tmp] < 0) {
					win[1+tmp] += 60;
					win[0+tmp]--;
				}
				if(win[1+tmp] >= 60) {
					win[1+tmp] -= 60;
					win[0+tmp]++;
				}
				
				check[1] = false;
				check[2] = false;
				time[0] = 0;
				time[1] = 0;
			}
		}
		if(check[1] || check[2]) {
			if(check[1])
				tmp = 0;
			else if(check[2])
				tmp = 2;
			
			win[0+tmp] += (48 - time[0]);
			win[1+tmp] += (0 - time[1]);
			if(win[1+tmp] < 0) {
				win[1+tmp] += 60;
				win[0+tmp]--;
			}
			if(win[1+tmp] >= 60) {
				win[1+tmp] -= 60;
				win[0+tmp]++;
			}
		}
		
		String prt = "";
		if(win[0] < 10)
			prt += "0";
		prt += win[0] + ":";
		if(win[1] < 10)
			prt += "0";
		prt += win[1];
		System.out.println(prt);
		
		prt = "";
		if(win[2] < 10)
			prt += "0";
		prt += win[2] + ":";
		if(win[3] < 10)
			prt += "0";
		prt += win[3];
		System.out.println(prt);
	}
}