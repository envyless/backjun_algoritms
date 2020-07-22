import java.io.*;
import java.util.StringTokenizer;

public class Problem_10409 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			time -= insert[i];
			if(time >= 0)
				count++;
		}
		System.out.println(count);
	}
}