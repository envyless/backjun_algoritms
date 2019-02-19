import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1713 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // Ʋ�� ���� �Է� ����
		int M = Integer.parseInt(br.readLine()); // ��õ Ƚ���� �Է� ����
		int[][] insert = new int[N][3]; 
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		int tmp;
		int start = 0;
		for(int i = 0 ; i < M ; i++) {
			tmp = Integer.parseInt(st.nextToken()); // ���� �������� ��õ ���� ����� ��ȣ�� tmp�� ��
			
			if(start < N) { // N���� �� Ʋ�� �����Ƿ� N���� �Է��� ���� �� ���� Ʋ�� ä��
				boolean startIn = true;
				for(int j = 0 ; j < start ; j++) {
					if(tmp == insert[j][0]) {
						insert[j][2]++;
						startIn = false;
					}
				}
				if(!startIn)
					continue;
				
				insert[start][0] = tmp; // 0���� ��õ�� ��ȣ
				insert[start][1] = i; // 1���� ��õ�� �ð�
				insert[start][2] = 1; // 2���� ��õ Ƚ��
				start++;
				continue;
			}
			
			// ���� �Ʒ��� ����ȴٴ� ����, Ʋ�� �� á�ٴ� �Ҹ�.
			int old = 1000;
			int reco = 1000; // ��õ�� �ִ� Ƚ���� 1000�̹Ƿ� �ִ��� 1000�� ����
			int index = 0;
			boolean yes = false;
			
			//Ʋ�� �� á����, N���� Ʋ�� Ȯ���ؼ� �̹� �ִ� ������� Ȯ��
			for(int j = 0 ; j < N ; j++) {
				
				if(tmp == insert[j][0]) { // 0���� ��ȣ�̹Ƿ�, ��õ�� ����� ������ ��õ Ƚ���� ����
					insert[j][2]++;
					yes = true; // ������ ���� ����� Ȯ���ϵ��� �ϱ� ���� ����
					break;
				}
				
				if(reco > insert[j][2]) // ���� ��õ�� ����� �ƴ� ���, reco ������ ��õ�� ���� ���� ���� ���� ��
					reco = insert[j][2];
			}
			
			if(yes) // Ʋ�� �̹� �ִ� ����� ��õ �Ǿ���, ��õ Ƚ���� �����������Ƿ� ���� ��õ�� �޴´�.
				continue;
			
			// �̰� �Ʒ��� ����Ǹ� Ʋ�� ���� ����� ��õ�Ǿ���.
			for(int j = 0 ; j < N ; j++) {
				if(reco == insert[j][2]) // ���� if���� ���Ͽ� reco���� ��õ�� �ּڰ��� ��. �ּڰ��� ���� ����� ���� �� �����Ƿ� ���� ��쿡�� ����
					if(old > insert[j][1]) { // �ּҰ� ������, ���� ������ ������ �����ؾ� ��. old�� Ŭ���� �ֽ�. ����, old�� ���� ���� ������
						old = insert[j][1]; // ���� old�� ���� ���� �� �̹Ƿ� old�� ���� ���� ����
						index = j; // ���� j�� index ���� ����.
					}
			}
			
			// index���� �ּ��� ��õ ���� reco�� �����鼭, �� �� old�� ���� ���� index�� ���� ���ο� ������ ���Ž�Ų��.
			insert[index][0] = tmp; // ���� ��õ ���� ����� �ش� index�� ����
			insert[index][1] = i; // ���� ���� �ϴ� �� �̹Ƿ�, ��õ ���� ������ ����
			insert[index][2] = 1; // ���� ���� �ϴ� �� �̹Ƿ� ��õ Ƚ���� 1�� �ٽ� ����
		}
		
		for(int i = 0 ; i < N ; i++)
			result[i] = insert[i][0];
		Arrays.sort(result);
		for(int i = 0 ; i < N ; i++)
			System.out.print(result[i] + " ");
	}
}