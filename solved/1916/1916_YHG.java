import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1916_2 {
	
	static Scanner scn = new Scanner(System.in);

	static int n = scn.nextInt();
	static int m = scn.nextInt();
	
	static int INF = 999999999;
	
	// 도시는 1 ~ n 이기 때문에, 배열 0을 사용하지 않기 위해 +1.
	static int[] distance = new int[n+1];
	static boolean[] visit = new boolean[n+1];
	static int[][] insert = new int[m][3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Distance> prq = new PriorityQueue<Distance>(new Compa());
		
		for(int i = 0; i < m ; i++) 
			for(int j = 0 ; j < 3 ; j++)
				insert[i][j] = scn.nextInt();
		
		int start = scn.nextInt();
		int end = scn.nextInt();
		
		for(int i = 0 ; i < n+1 ; i++) {
			distance[i] = INF;
			visit[i] = false;
		}
		
		distance[start] = 0;
		
		prq.add(new Distance(distance[start],start));
		
		while(!prq.isEmpty()) {
			Distance dis = prq.remove();
			
			int nowStart = dis.city;
			int nowDistance = dis.distance;
			
			if(!visit[nowStart]) {
				visit[nowStart] = true;
				
				for(int i = 0 ; i < m ; i++) {
					
					// insert[i][0] = start
					// insert[i][1] = end
					// insert[i][2] = distance	
					if(insert[i][0] == nowStart) {
						if(distance[insert[i][1]] > nowDistance + insert[i][2]) {
							distance[insert[i][1]] = nowDistance + insert[i][2];
						}
						prq.add(new Distance(distance[insert[i][1]],insert[i][1]));
					}
				}
				
			}
		}
		
		System.out.println(distance[end]);
	}
}

class Distance{
	public int distance;
	public int city;
	public Distance(int a, int b) {
		distance = a;
		city = b;
	}
}

class Compa implements Comparator<Distance>{
	
	public int compare(Distance d1, Distance d2) {
        return d1.distance < d2.distance ? -1 : 1;
    }
}