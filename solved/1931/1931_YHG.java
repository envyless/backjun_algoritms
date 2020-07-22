import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // ÃÑ È¸ÀÇ ¼ö
		PriorityQueue<meet> pq = new PriorityQueue<meet>(new time());
		
		for(int i = 0 ; i < N ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			pq.add(new meet(start,end));
		}
		
		
		int max = 1;
		meet now = pq.poll();
		int time = now.end;
		
		while(!pq.isEmpty()) {
			meet meet = pq.poll();
			int start = meet.start;
			int end = meet.end;
			
			if(start == end) {
				max++;
				continue;
			}
			
			if(start < time)
				continue;
			else {
				max++;
				time = end;
			}
		}
		
		System.out.println(max);
	}

}

class meet{
	int start;
	int end;
	
	public meet(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class time implements Comparator<meet>{
	
	public int compare(meet v1, meet v2) {
		if(v1.end == v2.end)
			return v1.start - v2.start < 0 ? -1 : 1;
		else
			return v1.end - v2.end < 0 ? -1 : 1;
    }
}