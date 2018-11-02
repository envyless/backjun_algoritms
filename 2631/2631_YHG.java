import java.io.*;

public class Problem_2631 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		int[] count = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) 
			for(int j = 0 ; j < i ; j++) 
				if(insert[i] > insert[j] && count[i] < count[j]+1)
					count[i] = count[j]+1;
		
		int max = 0;
		for(int i = 1 ; i <= N ; i++)
			if(max < count[i])
				max = count[i];
		System.out.println(N - max);
	}
}