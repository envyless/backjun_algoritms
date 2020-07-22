import java.io.*;
import java.util.StringTokenizer;

public class Problem_12790 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stet = new int[8];
		int hp,mp,atk,def;
		for(int T = 0 ; T < N ; T++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < 8 ; i++)
				stet[i] = Integer.parseInt(st.nextToken());
			
			hp = stet[0] + stet[4];
			if(hp <= 1) hp = 1;
			mp = stet[1] + stet[5];
			if(mp <= 1) mp = 1;
			atk = stet[2] + stet[6];
			if(atk <= 0) atk = 0;
			def = stet[3] + stet[7];
			int result = hp + mp * 5 + atk * 2 + def * 2;
			System.out.println(result);
		}
	}
}