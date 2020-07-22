import java.io.*;
import java.util.StringTokenizer;

public class Problem_2863 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		double C = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		
		int count = 0;
		double result, tmp;
		double max = A/C + B/D;
		for(int i = 0 ; i < 4 ; i++) {
			result = A/C + B/D;
			if(max < result) {
				max = result;
				count = i;
			}
			tmp = A;
			A = C;
			C = D;
			D = B;
			B = tmp;
		}
		System.out.println(count);
	}
}