import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		// 테스터 데이터의 갯수
		int t = scn.nextInt();
		
		int[] h = new int[t];
		int[] w = new int[t];
		int[] n = new int[t];
		
		for(int i = 0 ; i < t ; i++) {
			h[i] = scn.nextInt();
			w[i] = scn.nextInt();
			n[i] = scn.nextInt();
		}
		
		for(int i = 0 ; i < t ; i++) {
			// while 문에서 사용될 변수
			int h_tmp = 0;
			int w_tmp = 0;
			
			while(n[i] > 0) {
				n[i]--;
				//다음 배정할 호실 지정.
				if(n[i] != 0) {
					h_tmp++;
					// 크기 h 배열의 index는 0 ~ h-1
					if(h_tmp > h[i]-1) {
						h_tmp = 0;
						w_tmp++;
					}
				}
			}
			// 출력 결과는 X가 층, Y가 호수라고 할 때, XYY, XXYY 로 고정됨. 
			// 즉, 호수가 10 미만일 때는 0을 붙여서 출력
			String prt = "";
			prt += h_tmp+1;
			if(w_tmp < 9 ) prt += 0;
			prt += w_tmp+1;
			System.out.println(prt);
		}
	}
}
