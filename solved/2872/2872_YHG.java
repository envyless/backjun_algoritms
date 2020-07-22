import java.io.*;

public class Problem_2872 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		
		int start = N;
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		for(int i = N-1 ; i >= 0 ; i--)
			if(insert[i] == start)
				start--;
		
		System.out.println(start);
	}
}