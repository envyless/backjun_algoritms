import java.io.*;

public class Problem_1371 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

		String line;
		char tmp;
		char[] alpha = new char[26];
		
		while(true) {
			line = br.readLine();
			
			if(line == null)
				break;
			
			for(int i = 0 ; i < line.length() ; i++) {
				tmp = line.charAt(i);
				
				if(tmp == '\n' || tmp == ' ')
					continue;
				
				alpha[tmp - 'a']++;
			}
		}
		int max = 0;
		
		for(int i = 0 ; i < 26 ; i++)
			if(max < alpha[i])
				max = alpha[i];
		
		for(int i = 0 ; i < 26 ; i++)
			if(alpha[i] == max)
				bw.write('a' + i);
		bw.close();
	}
}