import java.io.*;

public class Problem_10988 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String insert = br.readLine();
		int len = insert.length();
		int index = len/2;
		boolean check = false;
		
		for(int i = 0 ; i < index ; i++) {
			if(insert.charAt(i) != insert.charAt(len-i-1))
				check = true;
		}
		
		if(check)
			System.out.println(0);
		else
			System.out.println(1);
	}
}