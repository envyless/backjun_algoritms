import java.io.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		Queue<Character> q = new LinkedList<Character>();
		
		int index = 1;
		int checkIndex = 0;
		int tmp = 0;
		while( index <= N+1 ) {
			
			if(st.isEmpty()) {
				if(index <= N)
					st.push(index++);
				else 
					break;
				q.add('+');
				continue;
			}
			
			tmp = st.pop();
			if(insert[checkIndex] == tmp) {
				q.add('-');
				checkIndex++;
				continue;
			}
			else {
				st.push(tmp);
				if(index <= N)
					st.push(index++);
				else
					break;
				q.add('+');
				continue;
			}
		}
		
		boolean checking = false;
		while(!st.isEmpty()) {
			int t = st.pop();
			if(t <= N)
				checking = true;
		}
		
		if(checking)
			System.out.println("NO");
		else
			while(!q.isEmpty())
				System.out.println(q.poll());
	}
}