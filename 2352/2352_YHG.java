import java.io.*;
import java.util.StringTokenizer;

public class Problem_2352 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] insert = new int[N];
		int[] count = new int[N];
		for(int i = 0 ; i < N ; i++)
			count[i] = 1;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < i ; j++)
				if(insert[i] > insert[j] && count[i] < count[j]+1)
					count[i] = count[j] + 1;
		
		int max = 0;
		for(int i = 0 ; i < N ; i++)
			if(max < count[i])
				max = count[i];
		
		System.out.println(max);
	}
}