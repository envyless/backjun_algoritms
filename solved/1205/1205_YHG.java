import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1205 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(1);
			return;
		}
		
		int[][] insert = new int[N][2];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i][0] = Integer.parseInt(st.nextToken());
		
		insert[0][1] = 1;
		for(int i = 1 ; i < N ; i++)
			if(insert[i][0] == insert[i-1][0])
				insert[i][1] = insert[i-1][1];
			else
				insert[i][1] = i+1;
		
		if(insert[0][0] < score) {
			System.out.println(1);
			return;
		}
		if(N == P && insert[N-1][0] >= score) { // ����Ʈ�� ũ�Ⱑ �ִ�, �� ������ ���� ���ο� ���� �̻��� ���� ����Ʈ�� �� �� ����.
			System.out.println(-1);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(score == insert[i][0] || score > insert[i][0]) {
				System.out.println(insert[i][1]);
				return;
				 // ����Ʈ ũ�Ⱑ �ִ밡 �ƴϰų�, ���� ���ǿ� ���� ����Ʈ�� �� ������ ���� ���� �����Ƿ� ������ ���� ����� ���� ����
				 // ���� ������ �ȳ�����, �ٷ� score���� ���� ������ ����. ����Ʈ�� ����ִ� ������ ũ�Ƿ�, �ش� ����� �����
			}
			else // score < insert[i][0], 
				if(i == N-1)
					System.out.println(N+1);
		}
	}
}