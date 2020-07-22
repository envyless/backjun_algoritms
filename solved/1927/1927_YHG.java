import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1927 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ASC_1927());
		
		int N = Integer.parseInt(br.readLine());
		int tmp;
		for(int i = 0 ; i < N ; i++) {
			tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
			else
				pq.add(tmp);
		}
	}

}
class ASC_1927 implements Comparator<Integer>{
	
	public int compare(Integer v1, Integer v2) {
		return v1 - v2 < 0 ? -1 : 1;
    }
}