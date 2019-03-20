import java.io.*;
import java.util.StringTokenizer;

public class Problem_2858 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken()); // side. 8 ~ 5,000
		int B = Integer.parseInt(st.nextToken()); // middle 1 ~ 2,000,000
		/*
		 * B =  갈색.
		 * 즉, 갈색의 가로 i, 세로를 j라고 했을 때, B = i * j
		 * j = B / i
		 * R 블록은 B 블록을 감싸고 있음.
		 * 따라서, i*2 + j*2 +4
		 */
		int j = 1;
		for(int i = 1 ; i < 1300 ; i++)
			if(B % i == 0) {
				j = B/i;
				if(i*2 + j*2 + 4 == R) {
					System.out.println((j+2) + " " + (i+2));
					return;
				}
			}
	}
}