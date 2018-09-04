import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_11650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정점의 수
		PriorityQueue<point_11650> pq = new PriorityQueue<point_11650>(new ASC_11650());
		for(int i = 0 ; i < N ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			pq.add(new point_11650(start,end));
		}
		
		while(!pq.isEmpty()) {
			point_11650 point = pq.poll();
			int x = point.x;
			int y = point.y;
			
			System.out.println(x + " " + y);
		}
	}

}
class point_11650{
	int x;
	int y;
	
	public point_11650(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ASC_11650 implements Comparator<point_11650>{
	
	public int compare(point_11650 v1, point_11650 v2) {
		if(v1.x == v2.x)
			return v1.y - v2.y < 0 ? -1 : 1;
		else
			return v1.x - v2.x < 0 ? -1 : 1;
    }
}