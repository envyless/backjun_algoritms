import java.io.*;
import java.util.StringTokenizer;

public class Problem_5046 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // N ��
		int B = Integer.parseInt(st.nextToken()); // ��� ���� �ݾ�
		int H = Integer.parseInt(st.nextToken()); // ȣ�� ��
		int W = Integer.parseInt(st.nextToken()); // Ȯ�� ������ ��
		
		int min = 600000;
		int tmp = 0;
		int[] week = new int[W];
		for(int i = 0 ; i < H ; i++) {
			int p = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < W ; j++)
				week[j] = Integer.parseInt(st.nextToken());
			
			tmp = p * N;
			if(tmp <= B) { // �ش� ȣ�ڿ� �ڸ��� ������ ���� ����
				for(int j = 0 ; j < W ; j++) {
					if(week[j] >= N) {
						if(tmp < min)
							min = tmp;
						break;
					}
				}
			}
		}
		
		if(min == 600000)
			System.out.println("stay home");
		else
			System.out.println(min);
	}
}