import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_4641 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		Queue<Integer> q = new LinkedList<Integer>();
		int tmp;
		int count;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			if(!q.isEmpty())
				q.remove();
			count = 0;
			
			while(true) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp == -1)
					return;
				if(tmp == 0)
					break;
				q.add(tmp);
			}
			
			int len = q.size();
			int[] insert = new int[len];
			for(int i = 0 ; i < len; i++)
				insert[i] = q.poll();
			
			
			for(int i = 0 ; i < len ; i++) {
				for(int j = 0 ; j < len ; j++) {
					if(insert[i]*2 == insert[j])
						count++;
					if(insert[j] == 0)
						break;
				}
				if(insert[i] == 0)
					break;
			}
			System.out.println(count);
		}
	}

}
