import java.util.Scanner; // Scanner로 입력 받기 위해 사용
import java.util.*; // Queue, LinkedList 사용

public class Problem_1697 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int N,K;
				
		N = scn.nextInt();
		K = scn.nextInt();	
		
		if(N == K) System.out.println(0);
		else if(N-1 == K || N+1 == K || N*2 == K) System.out.println(1);
		else
			BFS(N,K);
		
	}
	
	static void BFS(int N, int K) {
		// N이 0이 들어오는 경우, -1 했을 때 런타임 에러가 발생함.
		Queue q = new LinkedList();
		
		q.offer(N); // q.poll(); 은 제거.
		
		int tmp;
		int[] count = new int[200002];
		boolean[] check = new boolean[200002];
		
		while(true) { // 내부의 break를 만날 때 까지 무한 반복
			tmp = (int)q.poll();
			
			if(tmp == K) {
				System.out.println(count[tmp]);
				break;
			}
			
			// tmp - 1 했을 때 음수가되면 런타임 오류가 발생. 이 경우를 제외
			if(tmp - 1 > -1 && !check[tmp-1]) {
				q.offer(tmp-1);
				check[tmp-1] = true;
				count[tmp-1] = count[tmp] + 1;
			}
			
			// tmp에 1을 더했을 때, 최대값보다 크면 안된다.
			if(tmp+1 <= 100000 && !check[tmp+1]) {
				q.offer(tmp+1);
				check[tmp+1] = true;
				count[tmp+1] = count[tmp] + 1;
			}
			
			// 점의 범위는 0 ~ 10만 이다. K는 최대 10만이 될 수 있으므로 *2 했을 때
			// 20만보다 크면 index오류가 발생한다.
			if(tmp*2 <= 200000 && !check[tmp*2]) {
				q.offer(tmp*2);
				check[tmp*2] = true;
				count[tmp*2] = count[tmp] + 1;
			}
		}
	}
}
