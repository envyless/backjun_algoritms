import java.io.*;
import java.util.StringTokenizer;

public class Problem_5046 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // N 명
		int B = Integer.parseInt(st.nextToken()); // 사용 가능 금액
		int H = Integer.parseInt(st.nextToken()); // 호텔 수
		int W = Integer.parseInt(st.nextToken()); // 확인 가능한 주
		
		int min = 600000;
		int tmp = 0;
		int[] week = new int[W];
		for(int i = 0 ; i < H ; i++) {
			int p = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < W ; j++)
				week[j] = Integer.parseInt(st.nextToken());
			
			tmp = p * N;
			if(tmp <= B) { // 해당 호텔에 자리만 있으면 숙박 가능
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