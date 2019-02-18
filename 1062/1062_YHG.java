import java.io.*;
import java.util.StringTokenizer;

public class Problem_1062 {

	static int N;
	static int K;
	static int max = 0;
	static boolean[][] sen;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); // 문장 수
		K = Integer.parseInt(st.nextToken()); // 알파벳 수
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		boolean[] alpha = new boolean[26];
		sen = new boolean[N][26];
		
		String tmp = "antic";
		for(int i = 0 ; i < tmp.length() ; i++)
			alpha[tmp.charAt(i) - 'a'] = true;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < tmp.length() ; j++)
				sen[i][tmp.charAt(j) - 'a'] = true;
		}
		
		dfs(alpha, 5, 0);
		System.out.println(max);
	}
	
	static public void dfs(boolean[] alpha, int count, int index) {
		
		if(count != K && index < 26) {
			if(alpha[index])
				dfs(alpha, count, index+1);
			else {
				alpha[index] = true;
				dfs(alpha, count+1, index+1);
				alpha[index] = false;
				dfs(alpha, count, index+1);
			}
		}
		
		if(count == K) {
			int tmp = 0;
			boolean check = false;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < 26 ; j++) {
					if(sen[i][j] && !alpha[j]) {
						check = true;
						break;
					}
				}
				if(!check)
					tmp++;
				check = false;
			}
			
			if(max < tmp)
				max = tmp;
		}
	}
}