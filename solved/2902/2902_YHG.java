import java.io.*;

public class Problem_2902 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		
		for(int i = 0 ; i < insert.length() ; i++)
			if(insert.charAt(i) >= 'A' && insert.charAt(i) <= 'Z')
				System.out.print(insert.charAt(i));
	}
}