import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Problem_2252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] node = new ArrayList[N+1];
		int[] count = new int[N+1];
		ArrayList<Integer> Ar = new ArrayList<Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N ; i++)
			node[i] = new ArrayList<Integer>();
		
		int f,l;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			f = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			node[f].add(l);
			count[l]++;
		}
		
		for(int i = 1 ; i <= N ; i++)
			if(count[i] == 0)
				q.add(i);
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			Ar.add(now);
			
			for(int i = 0 ; i < node[now].size() ; i++) {
				int next = node[now].get(i);
				count[next]--;
				
				if(count[next] == 0)
					q.add(next);
			}
		}
		
		for(int i = 0 ; i < Ar.size() ; i++)
			System.out.print(Ar.get(i) + " ");
	}
}