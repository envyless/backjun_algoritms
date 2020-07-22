import java.io.*;

public class Problem_2231 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int start = N - 60;
		if(start < 0)
			start = 0;
		
		String tmp;
		int value;
		for(int i = start ; i <= N ; i++) {
			tmp = String.valueOf(i);
			value = i;
			for(int j = 0 ; j < tmp.length() ; j++)
				value += tmp.charAt(j) - '0';
			if(value == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}