import java.io.*;
import java.util.StringTokenizer;

public class Problem_1773 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[] time = new boolean[C+1];
		
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			int start = tmp;
			
			while(start <= C) {
				time[start] = true;
				start += tmp;
			}
		}
		
		int count = 0;
		for(int i = 1 ; i <= C ; i++)
			if(time[i])
				count++;
		
		System.out.println(count);
	}
}