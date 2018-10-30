import java.io.*;
import java.util.StringTokenizer;

public class Problem_11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // µ¿Àü Á¾·ù
		int K = Integer.parseInt(st.nextToken()); // µ·
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		int coin = 0;
		
		while(K > 0) {
			int div = 0;
			
			for(int i = N-1 ; i >= 0 ; i--)
				if(insert[i] <= K) {
					div = insert[i];
					break;
				}
			
			coin += K / div;
			K %= div;
		}
		System.out.println(coin);
	}
}