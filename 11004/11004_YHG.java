import java.io.*;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_11004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken()); // N°³
		int k = Integer.parseInt(st.nextToken()); // k¹øÂ°
		
		st = new StringTokenizer(br.readLine()," ");
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new AA());
		
		for(int i = 0 ; i < n ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			pq.add(tmp);
		}
		
		int index = 0;
		while(!pq.isEmpty()) {
			int value = pq.poll();
			if(index == k-1) {
				System.out.println(value);
				break;
			}
			else
				index++;
		}
	}

}
class AA implements Comparator<Integer>{
	
	public int compare(Integer v1, Integer v2) {
        return v1 - v2 < 0 ? -1 : 1;
    }
}
