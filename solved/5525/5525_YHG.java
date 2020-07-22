import java.io.*;

public class Problem_5525 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String in = br.readLine();
		char[] insert = new char[M];
		for(int i = 0 ; i < M ; i++)
			insert[i] = in.charAt(i);
		
		int count = 0;
		int result = 0;
		for(int i = 1 ; i < M - 1 ; i++) {	
			if(insert[i-1] == 'I' && insert[i] == 'O' && insert[i+1] == 'I') {
				count++;
				if(count == N) {
					result++;
					count--;
				}
				i++;
			}
			else
				count = 0;
		}
		System.out.println(result);
	}
}