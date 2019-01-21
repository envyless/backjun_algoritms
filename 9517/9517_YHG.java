import java.io.*;
import java.util.StringTokenizer;

public class Problem_9517 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int start = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		int finish = 210;
		int[] ti = new int[q];
		String[] ty = new String[q];
		
		for(int i = 0 ; i < q ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			ti[i] = Integer.parseInt(st.nextToken());
			ty[i] = st.nextToken(); // True , No , Pass
		}
		
		for(int i = 0 ; i < q ; i++) {
			int time = ti[i];
			String type = ty[i];
			
			if(type.equals("T")) {
				finish -= time;
				if(finish <= 0)
					break;
				start++;
				if(start == 9)
					start = 1;
			}
			else {
				finish -= time;
				if(finish <= 0)
					break;
			}
		}
		System.out.println(start);
	}
}