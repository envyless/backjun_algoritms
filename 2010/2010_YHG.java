import java.io.*;

public class Problem_2010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		int N = Integer.parseInt(br.readLine()); // ¸ÖÆ¼ÅÇÀÇ ¼ö
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 2 ; i <= N ; i++)
			count += Integer.parseInt(br.readLine()) - 1;
		
		System.out.println(count);
	}
}