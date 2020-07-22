import java.util.Scanner;

public class Problem_5567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // ������ ��
		int m = scn.nextInt(); // ����Ʈ�� ��
		boolean[] visit = new boolean[n+1];
		boolean[] friend = new boolean[n+1];
		int[][] insert = new int[m][2];
		int count = 0;
		
		for(int i = 0 ; i < m ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			insert[i][0] = start;
			insert[i][1] = end;
			if(start == 1) {
				visit[end] = true;
				count++;
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			if(visit[insert[i][0]] && !visit[insert[i][1]])
				friend[insert[i][1]] = true;
			if(!visit[insert[i][0]] && visit[insert[i][1]])
				friend[insert[i][0]] = true;
		}
		
		for(int i = 2 ; i <= n ; i++)
			if(friend[i] && !visit[i]) {
				count++;
			}
		
		System.out.println(count);
	}
}