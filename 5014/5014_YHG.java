import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_5014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int F = scn.nextInt(); // 건물 층수 , 1이상 100만 이하
		int S = scn.nextInt(); // 현재 위치 , 1이상
		int G = scn.nextInt(); // 가야할 위치 , 1이상 100만 이하. 
		int U = scn.nextInt(); // up , 0 이상
		int D = scn.nextInt(); // down , 100만 이하.
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[F+1]; // 층수는 0이 아닌 1부터 시작.
		int[] click = new int[F+1];
		
		q.add(S);
		
		if(S == G) 
			System.out.println(0);
		else {
			
			visit[S] = true;
			while(!q.isEmpty()) {
				
				int check = q.poll();
				
				int up = check + U; // up 시 100만 이상의 값이 나오면 그 값은 무효.
				int down = check - D; // down 시 0 이하의 값이 나오면 그 값은 무효.
				
				if( up <= F && !visit[up] ) {
					visit[up] = true;
					click[up] = click[check] + 1;
					q.add(up);
				}
				
				if(down > 0 && !visit[down] ) {
					visit[down] = true;
					click[down] = click[check] + 1;
					q.add(down);
				}
				
			}
			
			if(click[G] == 0)
				System.out.println("use the stairs");
			else
				System.out.println(click[G]);
		}
	}
}