import java.io.*;
import java.util.StringTokenizer;

public class Problem_1790 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 1 ~ N 이어붙이기
		int M = Integer.parseInt(st.nextToken()); // M 번째의 수
		
		int m = 10;
		int mi = 1;
		String result = "";
		for(int i = 1 ; i <= N ; i++) {
			if(i/m == 0)
				M -= mi;
			if(i/m == 1) {
				m *= 10;
				mi++;
				M -= mi;
			}
			if(M <= 0) {
				result = String.valueOf(i);
				break;
			}
		}
		
		if(M > 0)
			System.out.println(-1);
		else if(M == 0)
			System.out.println(result.charAt(result.length()-1));
		else
			System.out.println(result.charAt(result.length()+M-1));
	}
}