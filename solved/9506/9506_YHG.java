import java.io.*;

public class Problem_9506 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == -1)
				return;
			
			int[] value = new int[N];
			int sum = 0;
			int index = 0;
			for(int i = 1 ; i < N ; i++)
				if(N % i == 0) {
					value[index++] = i;
					sum += i;
				}
			
			if(sum != N) {
				System.out.println(N + " is NOT perfect.");
				continue;
			}
			
			System.out.print(N + " = ");
			for(int i = 0 ; i < index ; i++) {
				System.out.print(value[i]);
				if(i+1 != index)
					System.out.print(" + ");
			}
			System.out.println();
		}
	}
}