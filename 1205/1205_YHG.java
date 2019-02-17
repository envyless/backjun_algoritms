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
		if(N == P && insert[N-1][0] >= score) { // 리스트의 크기가 최대, 맨 마지막 값이 새로운 점수 이상일 때는 리스트에 들어갈 수 없음.
			System.out.println(-1);
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(score == insert[i][0] || score > insert[i][0]) {
				System.out.println(insert[i][1]);
				return;
				 // 리스트 크기가 최대가 아니거나, 위의 조건에 의해 리스트의 맨 마지막 값이 되지 않으므로 무조건 같은 등수로 삽입 가능
				 // 같은 점수가 안나오고, 바로 score보다 작은 점수가 나옴. 리스트에 들어있는 값보다 크므로, 해당 등수를 뺏어옴
			}
			else // score < insert[i][0], 
				if(i == N-1)
					System.out.println(N+1);
		}
	}
}