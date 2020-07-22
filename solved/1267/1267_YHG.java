import java.io.*;
import java.util.StringTokenizer;

public class Problem_1267 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());

		int Y = 0;
		int M = 0;
		for(int i = 0 ; i < N ; i++) {
			int tmp = insert[i] / 30;
			Y += (tmp+1) * 10;
			tmp = insert[i] / 60;
			M += (tmp+1) * 15;
		}
		
		if(Y < M)
			System.out.print("Y "+ Y);
		else if(Y > M)
			System.out.print("M "+ M);
		else
			System.out.print("Y M "+ M);
	}
}