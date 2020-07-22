import java.io.*;
import java.util.StringTokenizer;

public class Problem_3020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 장애물 갯수
		int H = Integer.parseInt(st.nextToken()); // 높이
		
		int[] down = new int[H+1];
		int[] top = new int[H+1];
		int[] sumDown = new int[H+4];
		int[] sumTop = new int[H+4];
		int[] result = new int[H+4];
		int min = 6000000;
		int count = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(i % 2 == 0)
				top[tmp]++;
			else
				down[tmp]++;
		}
		
		for(int i = H ; i >= 1 ; i--) {
			sumDown[i] = down[i] + sumDown[i+1];
			sumTop[i] = top[i] + sumTop[i+1];
		}
		
		for(int i = 1 ; i <= H ; i++) {
			result[i] = sumDown[i] + sumTop[H-i+1];
			if(result[i] == min)
				count++;
			else if(result[i] < min) {
				count = 1;
				min = result[i];
			}
		}
		
		System.out.println(min + " " + count);
	}
}