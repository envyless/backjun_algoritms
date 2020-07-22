import java.util.Scanner;

public class Problem_1977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 범위 A
		int M = scn.nextInt(); // 범위 B
		int sum = 0;
		int min = 0;
		boolean check = false;
		
		int tmpS = (int)Math.sqrt(N);
		int tmpE = (int)Math.sqrt(M) + 1;
		
		for(int i = tmpS ; i < tmpE ; i++) {
			int tmp = i*i;
			
			if(tmp >= N && tmp <= M)
				sum += tmp;
			
			if(!check && tmp >= N && tmp <= M) {
				check = true;
				min = tmp;
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}