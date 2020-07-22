import java.io.*;

public class Problem_3053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		double pi = Math.PI;
		
		System.out.println(String.format("%.5f", pi*N*N));
		System.out.println(String.format("%.5f", (double)2*N*N));
	}
}