import java.io.*;

public class Problem_1159 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		boolean check = false;
		for(int i = 0 ; i < N ; i++)
			alpha[br.readLine().charAt(0) - 'a']++;
		
		for(int i = 0 ; i < 26 ; i++)
			if(alpha[i] >= 5) {
				check = true;
				char tmp = 'a';
				tmp += i;
				System.out.print(tmp);
			}
		
		if(!check)
			System.out.println("PREDAJA");
	}
}