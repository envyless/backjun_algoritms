import java.io.*;
import java.util.StringTokenizer;

public class Problem_5032 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int now = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int recy = Integer.parseInt(st.nextToken());
		int count = 0;
		
		while(now > 0) {
			if(now >= recy) {
				int tmp = now / recy;
				now %= recy;
				now += tmp;
				count += tmp;
			}
			else
				break;
		}
		System.out.println(count);
	}
}