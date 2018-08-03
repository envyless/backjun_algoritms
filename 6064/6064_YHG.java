import java.util.Scanner;

public class Problem_6064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 캐이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int M = scn.nextInt();
			int N = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			int result = -1;
			
			for(int i = 0 ; i < N ; i++)
				if((M*i + x-1) % N+1 == y) {
					result = M*i + x;
					break;
				}
			System.out.println(result);
		}
	}
}