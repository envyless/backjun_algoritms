import java.io.*;
import java.util.StringTokenizer;

public class Problem_1712 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken()); // 고정
		int B = Integer.parseInt(st.nextToken()); // 변동
		int C = Integer.parseInt(st.nextToken()); // 판매
		
		int count = 0;
		
		if(A == 0) {
			if(B >= C)
				count = -1;
			else
				count = 1;
		}
		else {
			if(B >= C)
				count = -1;
			else {
				count = 1;
				while(true) {
					if(count > A / (C - B) )
						break;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}