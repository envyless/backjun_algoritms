import java.io.*;

public class Problem_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt(br.readLine());  // 자연수의 갯수
		int[] insert = new int[10001]; // 0 ~ 10,000 까지
		
		// 자연수의 갯수는 N개. 따라서 0부터 N-1까지 반복해서 입력 받음.
		for(int i = 0 ; i < N ; i ++)
			insert[Integer.parseInt(br.readLine())]++;
		
		// 입력된 index의 범위는 1부터 N
		for(int i = 1 ; i <= 10000 ; i++) {
			int tmp = insert[i];
			for(int j = 0 ; j < tmp ; j++)
				bw.write(i + "\n");
		}
		bw.close();
	}
}