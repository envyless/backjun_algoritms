import java.io.*;

public class Problem_2847 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = N-1 ; i > 0 ; i--) {
			if(insert[i] <= insert[i-1]) {
				int tmp = insert[i-1] - insert[i] + 1;
				insert[i-1] -= tmp;
				count += tmp;
			}
		}
		System.out.println(count);
	}
}