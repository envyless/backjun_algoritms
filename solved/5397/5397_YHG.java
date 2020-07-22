import java.io.*;
import java.util.Stack;

public class Problem_5397 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int TC = Integer.parseInt(br.readLine());
		Stack<Character> st1 = new Stack<Character>();
		Stack<Character> st2 = new Stack<Character>();
		char tmp;
		
		for(int i = 0 ; i < TC ; i++) {
			String insert = br.readLine(); // < > -
			st1.removeAllElements();
			st2.removeAllElements();
			
			
			for(int j = 0 ; j < insert.length() ; j++) {
				tmp = insert.charAt(j);
				
				if( (tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z') || (tmp >= '0' && tmp <= '9'))
					st1.push(tmp);
				else if(tmp == '<' && !st1.isEmpty())
					st2.push(st1.pop());
				else if(tmp == '>' && !st2.isEmpty())
					st1.push(st2.pop());
				else if(tmp == '-' && !st1.isEmpty())
					st1.pop();
			}
			while(!st1.isEmpty())
				st2.push(st1.pop());
			while(!st2.isEmpty())
				bw.write(st2.pop());
			bw.write("\n");
		}
		bw.close();
	}
}