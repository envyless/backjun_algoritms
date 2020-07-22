import java.io.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Problem_10845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st; 
		
		Queue<Integer> q = new LinkedList<Integer>(); // FIFO ±¸Á¶.
		
		int N = Integer.parseInt(br.readLine());
		
		String tmp;
		int save = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			tmp = st.nextToken();
			
			if(tmp.equals("push")) {
				save = Integer.parseInt(st.nextToken());
				q.add(save);
			}
			else if(tmp.equals("pop"))
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
			else if(tmp.equals("size"))
				System.out.println(q.size());
			else if(tmp.equals("empty"))
				if(q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			else if(tmp.equals("front"))
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek()); 
			else if(tmp.equals("back"))
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(save);
		}
	}
}