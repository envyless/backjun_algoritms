import java.io.*;

public class Problem_1718 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		String pwd = br.readLine();
		int len = pwd.length();
		int j = 0;
		for(int i = 0 ; i < insert.length() ; i++, j++) {
			int tmp = insert.charAt(i) - 'a';
			if(j == len)
				j = 0;
			int tmp2 = pwd.charAt(j) - 'a';
			
			if(tmp == -65) {
				System.out.print(" ");
				continue;
			}
			
			if(tmp < tmp2)
				tmp += 25;
			else
				tmp -= 1;
			
			tmp -= tmp2;
			if(tmp == -1)
				tmp = 25;
			System.out.print((char)(tmp + 'a'));
		}
	}
}