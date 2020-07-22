import java.io.*;

public class Problem_3474 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int count, tmp;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = Integer.parseInt(br.readLine());
			count = 0;
			
			for(int j = 5 ; j <= tmp ; j *= 5)
				count += tmp/j;
			
			System.out.println(count);
		}
	}
}