import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1269 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ASC_1269());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			pq.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < M ; i++)
			pq.add(Integer.parseInt(st.nextToken()));
		
		int count = 0;
		boolean check = false;
		int value = pq.poll();
		int tmp;
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			if(tmp == value) {
				check = true;
				continue;
			}
			else {
				if(!check) 
					count++;
				check = false;
				value = tmp;
			}
		}
		if(!check)
			count++;
		System.out.println(count);
	}
}
class ASC_1269 implements Comparator<Integer>{
	
	public int compare(Integer v1, Integer v2) {
		return v1 - v2 < 0 ? -1 : 1;
    }
}