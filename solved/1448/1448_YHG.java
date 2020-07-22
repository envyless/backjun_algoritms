import java.io.*;
import java.util.Arrays;

public class Problem_1448 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(insert);
		
		int a,b,c;
		for(int i = N-1 ; i >= 2 ; i--) {
			a = insert[i];
			b = insert[i-1];
			c = insert[i-2];
			if(a+b>c && b+c>a && a+c>b) {
				System.out.println(a+b+c);
				return;
			}
		}
		System.out.println(-1);
	}
}