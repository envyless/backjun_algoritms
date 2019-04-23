import java.io.*;

public class Problem_1676 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		
		int countF = 0;
		
		for(int i = 1 ; i <= N ; i++)
			if(i%5 == 0) {
				int tmp = i;
				while(tmp % 5 == 0) {
					countF++;
					tmp /= 5;
				}
			}
		System.out.println(countF);
	}
}