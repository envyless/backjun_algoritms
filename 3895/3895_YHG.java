import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Problem_3895 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()) - 1;
			
			if(N == 0)
				return;
			
			LinkedList<Integer> ll = new LinkedList<Integer>();
			for(int i = 1 ; i <= N ; i++)
				ll.add(i);
			
			int last = ll.get(M);
			ll.remove(M);
			int index = M;
			while(!ll.isEmpty()) {
				index += K-1;
				if(index >= ll.size()-1)
					index = index % ll.size();
				last = ll.get(index);
				ll.remove(index);
			}
			System.out.println(last);
		}
	}
}