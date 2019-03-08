import java.io.*;
import java.util.StringTokenizer;

public class Problem_2783 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		float value = Float.parseFloat(st.nextToken()) / Float.parseFloat(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		float tmp;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			tmp = Float.parseFloat(st.nextToken()) / Float.parseFloat(st.nextToken());
			if(value > tmp)
				value = tmp;
		}
		System.out.println(String.format("%.2f", value*1000));
	}
}