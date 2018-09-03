import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_11724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정점의 수
		int M = scn.nextInt(); // 간선의 수
		int[] line = new int[N+1];
		PriorityQueue<point_11724> pq = new PriorityQueue<point_11724>(new ASC_11724());
		
		for(int i = 0 ; i < M ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			pq.add(new point_11724(start,end));
		}
		
		int count = 0;
		
		while(!pq.isEmpty()) {
			point_11724 point = pq.poll();
			int start = point.start;
			int end = point.end;
			
			if(line[start] == 0 && line[end] == 0) {
				count++;
				line[start] = count;
				line[end] = count;
			}
			else {
				if(line[start] == 0 && line[end] != 0)
					line[start] = line[end];
				else if(line[start] != 0 && line[end] == 0)
					line[end] = line[start];
			}
		}
		for(int i = 1 ; i < N+1 ; i++)
			if(line[i] == 0)
				count++;
		
		System.out.println(count);
	}
}

class point_11724{
	int start;
	int end;
	
	public point_11724(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class ASC_11724 implements Comparator<point_11724>{
	
	public int compare(point_11724 v1, point_11724 v2) {
		if(v1.start == v2.start)
			return v1.end - v2.end < 0 ? -1 : 1;
		else
			return v1.start - v2.start < 0 ? -1 : 1;
    }
}