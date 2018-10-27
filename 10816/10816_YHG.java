import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class Problem_10816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] check = new int[M];
		for(int i = 0 ; i < M ; i++)
			check[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(insert);
		
		int[] save = new int[N];
		save[0] = 1;
		for(int i = 1 ; i < N ; i++) {
			if(insert[i] == insert[i-1])
				save[i] = save[i-1] + 1;
			else
				save[i] = 1;
		}
		for(int i = N-1 ; i > 0 ; i--)
			if(insert[i] == insert[i-1])
				save[i-1] = save[i];
		
		for(int i = 0 ; i < M ; i++) {
			int start = 0;
			int end = N-1;
			int value = 0;
			int count = 0;
			boolean find = false;
			
			while(start <= end) {
				int mid = (start + end)/2;
				
				if(check[i] == insert[mid]) {
					find = true;
					value = mid;
					count++;
					break;
				}
				else if(check[i] > insert[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
			
			if(find)
				count = save[value];
			bw.write(count + " ");
		}
		bw.close();
	}
}