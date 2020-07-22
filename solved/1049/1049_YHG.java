import java.io.*;
import java.util.StringTokenizer;

public class Problem_1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minP = 100000;
		int minE = 100000;
		int P = 0;
		int E = 0;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			P = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			if(minP > P)
				minP = P;
			if(minE > E)
				minE = E;
		}
		
		int result = 0;
		
		if(minE * 6 < minP)
			result = minE * N;
		else {
			while(N >= 6) {
				N -= 6;
				result += minP;
			}
			
			if(N * minE > minP)
				result += minP;
			else
				result += minE * N;
		}
		System.out.println(result);
	}
}