import java.io.*;
import java.util.Stack;

public class Problem_10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String tmp = br.readLine();
		Stack<Character> st = new Stack<Character>();
		
		int tmpLen = tmp.length();
		for(int i = 0 ; i < tmpLen ; i++) {
			if(tmp.charAt(i) == '(' && tmp.charAt(i+1) == ')') {
				st.push('*');
				i++;
			}
			else
				st.push(tmp.charAt(i));
		}
		
		int count = 0;
		int piece = 0;
		int stLen = st.size();
		
		for(int i = 0 ; i < stLen ; i++) {
			char pop = st.pop();
			if(pop == ')')
				count++;
			if(pop == '(') {
				count--;
				piece++;
			}
			if(pop == '*')
				piece += count;
		}
		System.out.println(piece);
	}
}