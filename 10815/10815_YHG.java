import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class Problem_10815 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
				
		int N = Integer.parseInt(br.readLine()); // ������ �ִ� ���� ī��
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] insert = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); // �־��� ���� ī��
		st = new StringTokenizer(br.readLine(), " ");
		int[] check = new int[M];
		for(int i = 0 ; i < M ; i++)
			check[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(insert);
		
		// �̺� Ž��
		for(int i = 0 ; i < M ; i++) {
			int start = 0;
			int end = N-1;
			boolean isOne = false;
			
			while(start <= end) {
				int mid = (start + end)/2;
				
				if(check[i] == insert[mid]) {
					isOne = true;
					break;
				}
				else if(check[i] > insert[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}

			if(isOne)
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
	}
}