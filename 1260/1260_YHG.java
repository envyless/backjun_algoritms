import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정점의 수
		int M = scn.nextInt(); // 간선의 수
		int V = scn.nextInt(); // 시작 정점
		
		boolean[][] line = new boolean[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int[] check = new int[N];
		
		for(int i = 0 ; i < M ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			line[start][end] = true;
			line[end][start] = true;
		}
		
		q.add(V);
		visit[V] = true;
		check[0] = V;
		int index = 1;
		// DFS
		while(!q.isEmpty()) {
			int start = q.poll();
			int count = 0;
			
			System.out.print(start + " ");
			for(int i = 1 ; i <= N ; i++) {
				if(line[start][i] || line[i][start]) {
					if(!visit[i]) {
						q.add(i);
						visit[i] = true;
						check[index++] = i;
						break;
					}
				}
				count++;
			}
			
			if(count == N) {
				int checkIndex = index-1;
				while(count == N) {
					count = 0;
					if(checkIndex < 0)
						break;
					start = check[checkIndex--];
					for(int i = 1 ; i <= N ; i++) {
						if(line[start][i] || line[i][start]) {
							if(!visit[i]) {
								q.add(i);
								visit[i] = true;
								check[index++] = i;
								break;
							}
						}
						count++;
					}
				}
			}
		}
		
		System.out.println();
		for(int i = 0 ; i <= N ; i++)
			visit[i] = false;
		
		q2.add(V);
		visit[V] = true;
		// BFS
		while(!q2.isEmpty()) {
			int start = q2.poll();
			
			System.out.print(start + " ");
			for(int i = 1 ; i <= N ; i++) {
				if(line[start][i] || line[i][start]) {
					if(!visit[i]) {
						q2.add(i);
						visit[i] = true;
						continue;
					}
				}
			}
		}
	}
}

class Link_1260{
	int start;
	int end;
	
	public Link_1260(int start, int end) {
		this.start = start;
		this.end = end;
	}
}