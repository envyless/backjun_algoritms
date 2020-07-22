import java.io.*;

public class Problem_1788 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		int N = Integer.parseInt(br.readLine());
		
		int one = 0;
		int two = 1;
		int three = 1;
		
		if(N == 0 || Math.abs(N) == 1) {
			System.out.println(Math.abs(N));
			System.out.println(Math.abs(N));
			return;
		}
		else if(Math.abs(N) == 2) {
			if(N == 2)
				System.out.println(1);
			else
				System.out.println(-1);
			System.out.println(1);
			return;
		}
		
		boolean minus = false;
		if(N < 0)
			minus = true;
		N = Math.abs(N);
		
		for(int i = 3 ; i <= N ; i++) {
			one = two;
			two = three;
			three = (one + two) % 1000000000;
		}
		
		if(minus && N % 2 == 0)
			System.out.println(-1);
		else
			System.out.println(1);
		System.out.println(three);
	}
}