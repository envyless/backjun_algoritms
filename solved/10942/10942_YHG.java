import java.io.*;
import java.util.StringTokenizer;

public class Problem_10942 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); // 질문의 갯수
		int[] qs = new int[2];
		
		
		for(int i = 0 ; i < M ; i++) {
			int result = 1; // 팰린드롬 : 1 , 팰린드롬x : 0
			st = new StringTokenizer(br.readLine()," ");
			qs[0] = Integer.parseInt(st.nextToken()) -1; // 배열의 index는 0부터 시작.
			qs[1] = Integer.parseInt(st.nextToken()) -1; // 따라서, 입력된 값-1을 해서 index를 맞춤.
			
			while(qs[0] <= qs[1]) {
				if(insert[qs[0]] == insert[qs[1]]) {
					qs[0]++;
					qs[1]--;
				}else {
					result = 0;
					break;
				}
			}
			bw.write(result + "\n");
		}
		bw.close();
	}
}