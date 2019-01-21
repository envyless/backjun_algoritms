import java.io.*;

public class Problem_10987 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String insert = br.readLine();
		int count = 0;
		
		for(int i = 0 ; i < insert.length() ; i++) {
			char tmp = insert.charAt(i);
			if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u')
				count++;
		}
		System.out.println(count);
	}
}