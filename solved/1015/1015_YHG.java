import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1015 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] insert = new int[N];
		int[] sort = new int[N];
		int[] count = new int[N];
		for(int i = 0 ; i < N ; i++)
			count[i] = -1;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
			insert[i] = Integer.parseInt(st.nextToken());
			sort[i] = insert[i];
		}
		
		Arrays.sort(sort);
		int tmp = 0;
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				if(insert[j] == sort[i] && count[j] == -1)
					count[j] = tmp++;
		
		for(int i = 0 ; i < N ; i++)
			System.out.print(count[i] + " ");
	}

}
