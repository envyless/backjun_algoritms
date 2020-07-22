import java.io.*;
import java.util.StringTokenizer;

public class Problem_2812 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int saveK = K;
		
		String tmp = br.readLine();
		int[] number = new int[N];
		number[0] = tmp.charAt(0) - '0';
		int index = 1;
		int tmpV;
		int numberIndex = 1;
		while(numberIndex < N ) {
			tmpV = tmp.charAt(numberIndex++) - '0';
			while(K > 0 && index > 0 && number[index-1] < tmpV) {
				index--;
				K--;
			}
			number[index++] = tmpV;
		}
		
		for(int i = 0 ; i < N - saveK ; i++)
			System.out.print(number[i]);
	}
}