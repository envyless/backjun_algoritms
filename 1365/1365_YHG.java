import java.io.*;
import java.util.StringTokenizer;

public class Problem_1365 {

	static int[] input;
	static int[] count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		count = new int[N+1];
		int index = 1;
		count[0] = input[0];
		
		for (int i = 1; i < N; i++) {
	        if (count[index - 1] < input[i]) {
	            count[index] = input[i];
	            index++;
	            continue;
	        }
	 
	        count[lower_bound(0, index - 1, input[i])] = input[i];
	    }
	    
	    System.out.println(N - index);
	}
	
	static int lower_bound(int s, int e, int value) {
	    
	    while (s <= e) {
	        int mid = (s + e) / 2;
	        if (count[mid] >= value)
	        	e = mid - 1;
	        else
	        	s = mid + 1;
	    }
	 
	    return s;
	}
}