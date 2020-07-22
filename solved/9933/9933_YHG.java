import java.io.*;

public class Problem_9933 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine()); // 단어의 수
		String[] line = new String[N];
		
		for(int i = 0 ; i < N ; i++)
			line[i] = br.readLine();
		
		if(N == 1 || N == 2) {
			System.out.println(line[0].length() + " " + line[0].charAt(line[0].length()/2));
			return ;
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			int len = line[i].length();
			boolean check = false;
			for(int j = i ; j < N ; j++) {
				if(len != line[j].length())
					continue;
				for(int k = 0 ; k < len ; k++) {
					if(line[i].charAt(k) == line[j].charAt(len-k-1))
						check = true;
					else {
						check = false;
						break;
					}
				}
				if(check) {
					System.out.println(len + " " + line[i].charAt(line[i].length()/2));
					return ;
				}
			}
		}
	}
}