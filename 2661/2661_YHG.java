import java.io.*;

public class Problem_2661 {

	static int[] insert;
	static int N;
	static boolean finish = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		N = Integer.parseInt(br.readLine());
		insert = new int[N+1];
		start(1);
	}
	
	static public void start(int len) {
		
		if(len >= N+1) {
			for(int i = 1 ; i <= N ; i++)
				System.out.print(insert[i]);
			finish = true;
			return;
		}
		
		for(int i = 1 ; i <= 3 ; i++) {
			if(i == insert[len - 1])
				continue;
			insert[len] = i;
			
			if(search(len))
				start(len +1);
			if(finish)
				return;
		}
	}
	
	static public boolean search(int len) {
		
		for(int i = len-1 ; i >= 0 ; i--) {
			if(insert[len] == insert[i]) {
				int index = 1;
				for(int j = i-1 ; j >= 0 ; j--) {
					if(insert[j] != insert[len-index])
						break;
					index++;
					if(len-index == i)
						return false;
				}
			}
		}
		return true;
	}
}