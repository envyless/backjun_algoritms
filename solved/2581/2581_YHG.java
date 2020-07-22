import java.io.*;

public class Problem_2581 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] odd = new boolean[10001];
		
		for(int i = 2 ; i <= 10000 ; i++)
			odd[i] = true;
		
		for(int i = 2 ; i * i <= 10000 ; i++)
			if(odd[i])
				for(int j = i * i ; j <= 10000 ; j += i)
					odd[j] = false;
		
		int min = -1;
		int sum = 0;
		boolean first = true;
		for(int i = N ; i <= M ; i++) {
			if(odd[i]) {
				sum += i;
				if(first) {
					first = false;
					min = i;
				}
			}
		}
		
		if(min != -1)
			System.out.println(sum);
		System.out.println(min);
	}
}