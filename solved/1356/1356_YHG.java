import java.io.*;

public class Problem_1356 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String num = br.readLine();
		int len = num.length();
		
		int left = 1;
		int right = 1;
		boolean check = false;
		
		for(int i = 0 ; i < len-1 ; i++) {
			left = 1;
			right = 1;
			
			for(int j = 0 ; j <= i ; j++)
				left = left * (num.charAt(j) - '0');
			
			for(int j = i+1 ; j < len ; j++)
				right = right * (num.charAt(j) - '0');
			
			if(left == right) {
				check = true;
				break;
			}	
		}
		
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}