import java.io.*;
import java.util.StringTokenizer;

public class Problem_1546 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		double[] insert = new double[N];
		double max = 0;
		for(int i = 0 ; i < N ; i++) {
			insert[i] = Double.parseDouble(st.nextToken());
			if(max < insert[i])
				max = insert[i];
		}
		
		double sum = 0;
		for(int i = 0 ; i < N ; i++) {
			insert[i] = (insert[i]/max)*100;
			sum += insert[i];
		}
		
		System.out.println(String.format("%.2f", sum/N));
	}
}