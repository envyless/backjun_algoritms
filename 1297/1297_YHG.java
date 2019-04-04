import java.io.*;
import java.util.StringTokenizer;

public class Problem_1297 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int d = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int sum = h*h + w*w;
		
		double pt = Math.sqrt((double)d*d / sum);
		
		System.out.println((int)(h*pt) + " " + (int)(w*pt));
	}
}