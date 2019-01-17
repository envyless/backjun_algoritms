import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_2170 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		PriorityQueue<draw_2170> pq = new PriorityQueue<draw_2170>(new ASC_2170());
		
		int N = Integer.parseInt(br.readLine());
		
		int x = 0;
		int y = 0;
		int tmp = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x > y) {
				tmp = x;
				x = y;
				y = tmp;
			}
			if(x == y)
				continue;
			pq.add(new draw_2170(x, y));
		}
		
		int count = 0;
		draw_2170 now = pq.poll();
		int start = now.start;
		int end = now.end;
		while(!pq.isEmpty()) {
			now = pq.poll();
			int tS = now.start;
			int tE = now.end;
			
			if(tS >= start && tS <= end) {
				if(tE > end)
					end = tE;
				continue;
			}
			else {
				tmp = end - start;
				count += Math.abs(tmp);
				start = tS;
				end = tE;
			}
		}
		
		tmp = end - start;
		count += Math.abs(tmp);
		System.out.println(count);
	}

}
class draw_2170{
	int start;
	int end;
	
	public draw_2170(int x, int y) {
		this.start = x;
		this.end = y;
	}
}

class ASC_2170 implements Comparator<draw_2170>{
	
	public int compare(draw_2170 v1, draw_2170 v2) {
		if(v1.start == v2.start)
			return v1.end - v2.end < 0 ? -1 : 1;
		else
			return v1.start - v2.start < 0 ? -1 : 1;
    }
}