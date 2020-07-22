import java.io.*;

public class Problem_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt(br.readLine());  // �ڿ����� ����
		int[] insert = new int[10001]; // 0 ~ 10,000 ����
		
		// �ڿ����� ������ N��. ���� 0���� N-1���� �ݺ��ؼ� �Է� ����.
		for(int i = 0 ; i < N ; i ++)
			insert[Integer.parseInt(br.readLine())]++;
		
		// �Էµ� index�� ������ 1���� N
		for(int i = 1 ; i <= 10000 ; i++) {
			int tmp = insert[i];
			for(int j = 0 ; j < tmp ; j++)
				bw.write(i + "\n");
		}
		bw.close();
	}
}