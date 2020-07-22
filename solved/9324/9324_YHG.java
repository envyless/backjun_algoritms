import java.io.*;

public class Problem_9324 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			String msg = br.readLine();
			
			char[] alpha = new char[26];
			int len = msg.length();
			boolean check = true;
			
			for(int i = 0 ; i < len ; i++) {
				char tmp = msg.charAt(i);
				int index = tmp - 'A';
				alpha[index]++;
				
				if(alpha[index] == 3) {
					i++;
					if(i >= len) {
						check = false;
						break;
					}
					if(msg.charAt(i) == tmp)
						alpha[index] = 0;
					else {
						check = false;
						break;
					}
				}
			}
			if(check)
				System.out.println("OK");
			else
				System.out.println("FAKE");
		}
	}
}