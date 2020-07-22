import java.io.*;

public class Problem_5598 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		
		for(int i = 0 ; i < insert.length() ; i++) {
			char tmp = insert.charAt(i);
			
			if(tmp <= 'C')
				tmp += 26;
			tmp -= 3;
			System.out.print(tmp);
		}
	}
}