import java.io.*;
import java.util.StringTokenizer;

public class Problem_2965 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int tmp;
		int count = 0;
		
		while(true) {
			if(B-A > C-B) { // 앞이 더 큰 경우
				C = A+1;
				if(C == B)
					break;
				count++;
				tmp = C;
				C = B;
				B = tmp;
			}
			else { // 뒤가 더 큰 경우
				A = C-1;
				if(A == B)
					break;
				count++;
				tmp = A;
				A = B;
				B = tmp;
			}
		}
		System.out.println(count);
	}
}