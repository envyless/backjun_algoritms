import java.io.*;
import java.util.StringTokenizer;

public class Problem_9466 {

	static int[] insert;
	static int[] team;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine()); // 학생 수
			insert = new int[N+1]; // 각 학생이 원하는 학생이 저장.
			team = new int[N+1]; // 1 : team. 그외 : team x
			visit = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 1 ; i <= N ; i++)
				insert[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 1 ; i <= N ; i++)
				dfs(i, insert[i]);
			
			int count = 0;
			for(int i = 1 ; i <= N ; i++)
				if(team[i] != 1) {
					System.out.println(i + " is not team one .. ");
					count++;
				}
			System.out.println(count);
		}
	}
	
	static public boolean dfs(int start, int next) {
		
		if(team[next] == 0 || (team[next] == 2 && visit[next])) {
			team[next] = 1;
			
			if(start == next)
				return true;
			
			if(!dfs(start, insert[next])) {
				team[next] = 2;
				return false;
			}
			else
				return true;
		}
		
		visit[next] = true;
		return false;
	}
}