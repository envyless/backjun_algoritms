import java.io.*;
import java.util.Stack;

public class Problem_3986 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		
		String line;
		char tmp;
		int count = 0;
		Stack<Character> s = new Stack<Character>();
		
		for(int i = 0 ; i < N ; i++) {
			line = br.readLine();
			s.removeAllElements();
			for(int j = 0 ; j < line.length() ; j++) {
				if(s.isEmpty())
					s.push(line.charAt(j));
				else {
					tmp = s.pop();
					if(tmp != line.charAt(j)) {
						s.push(tmp);
						s.push(line.charAt(j));
					}
				}
			}
			
			if(s.isEmpty())
				count++;
		}
		System.out.println(count);
	}
}