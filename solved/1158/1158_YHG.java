import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1 ; i <= N ; i++)
			q.add(i);
		
		int count = 0;
		int tmp;
		System.out.print("<");
		while(!q.isEmpty()) {
			count++;
			tmp = q.poll();
			if(count == M) {
				count = 0;
				System.out.print(tmp);
				if(!q.isEmpty())
					System.out.print(", ");
			}
			else
				q.add(tmp);
		}
		System.out.print(">");
	}
}