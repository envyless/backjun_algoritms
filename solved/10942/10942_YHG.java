import java.io.*;
import java.util.StringTokenizer;

public class Problem_10942 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt(br.readLine()); // ������ ũ��
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); // ������ ����
		int[] qs = new int[2];
		
		
		for(int i = 0 ; i < M ; i++) {
			int result = 1; // �Ӹ���� : 1 , �Ӹ����x : 0
			st = new StringTokenizer(br.readLine()," ");
			qs[0] = Integer.parseInt(st.nextToken()) -1; // �迭�� index�� 0���� ����.
			qs[1] = Integer.parseInt(st.nextToken()) -1; // ����, �Էµ� ��-1�� �ؼ� index�� ����.
			
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