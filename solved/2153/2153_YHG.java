import java.io.*;

public class Problem_2153 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		boolean[] odd = new boolean[1100];
		
		for(int i = 1 ; i < 1100 ; i++)
			odd[i] = true;
		
		for(int i = 2 ; i * i < 1100 ; i++)
			if(odd[i])
				for(int j = i * i ; j < 1100 ; j += i)
					odd[j] = false;
		
		String insert = br.readLine();
		int value = 0;
		
		char tmp;
		for(int i = 0 ; i < insert.length() ; i++) {
			tmp = insert.charAt(i);
			
			if(tmp >= 'A' && tmp <= 'Z')
				value += (tmp - 'A' + 27);
			else
				value += (tmp - 'a' + 1);
		}
		
		if(odd[value])
			System.out.println("It is a prime word.");
		else
			System.out.println("It is not a prime word.");
	}
}