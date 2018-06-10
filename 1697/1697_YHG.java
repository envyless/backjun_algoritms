import java.util.Scanner; // Scanner�� �Է� �ޱ� ���� ���
import java.util.*; // Queue, LinkedList ���

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
		// N�� 0�� ������ ���, -1 ���� �� ��Ÿ�� ������ �߻���.
		Queue q = new LinkedList();
		
		q.offer(N); // q.poll(); �� ����.
		
		int tmp;
		int[] count = new int[200002];
		boolean[] check = new boolean[200002];
		
		while(true) { // ������ break�� ���� �� ���� ���� �ݺ�
			tmp = (int)q.poll();
			
			if(tmp == K) {
				System.out.println(count[tmp]);
				break;
			}
			
			// tmp - 1 ���� �� �������Ǹ� ��Ÿ�� ������ �߻�. �� ��츦 ����
			if(tmp - 1 > -1 && !check[tmp-1]) {
				q.offer(tmp-1);
				check[tmp-1] = true;
				count[tmp-1] = count[tmp] + 1;
			}
			
			// tmp�� 1�� ������ ��, �ִ밪���� ũ�� �ȵȴ�.
			if(tmp+1 <= 100000 && !check[tmp+1]) {
				q.offer(tmp+1);
				check[tmp+1] = true;
				count[tmp+1] = count[tmp] + 1;
			}
			
			// ���� ������ 0 ~ 10�� �̴�. K�� �ִ� 10���� �� �� �����Ƿ� *2 ���� ��
			// 20������ ũ�� index������ �߻��Ѵ�.
			if(tmp*2 <= 200000 && !check[tmp*2]) {
				q.offer(tmp*2);
				check[tmp*2] = true;
				count[tmp*2] = count[tmp] + 1;
			}
		}
	}
}
