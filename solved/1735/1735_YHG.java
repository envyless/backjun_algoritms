import java.io.*;
import java.util.StringTokenizer;

public class Problem_1735 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N1 = Integer.parseInt(st.nextToken());
		int M1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int N2 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		
		
		int top = N1 * M2 + N2 * M1;
		int bot = M1 * M2;
		int max = Math.max(top, bot);
		int min = Math.min(top, bot);
		int r;
		while(min != 0) {
			r = max%min;
			max = min;
			min = r;
		}
		if(max == 1)
			System.out.println(top + " " + bot);
		else {
			top /= max;
			bot /= max;
			System.out.println(top + " " + bot);
		}
	}
}