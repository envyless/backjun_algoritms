import java.io.*;
import java.util.StringTokenizer;

public class Problem_2980 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] insert = new int[N+1][3]; // 1 : ��ġ, 2 : ��, 3 : ��
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			insert[i][0] = Integer.parseInt(st.nextToken());
			insert[i][1] = Integer.parseInt(st.nextToken());
			insert[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		int start = 0;
		int index = 0;
		int stop = 0;
		while(start < L) {
			time++;
			stop = insert[index][0];
			if(start == stop) {
				int tmp = time % (insert[index][1] + insert[index][2]);
				if(tmp == 0) // �ʷϺ�
					index++;
				else if(tmp - insert[index][1] <= 0) // ������
					continue;
				else // �ʷϺ�
					index++;
			}
			start++;
		}
		System.out.println(time);
	}
}