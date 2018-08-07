import java.util.Scanner;

public class Problem_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 자연수 N : 1 ~ 1,000
		
		if(N < 100) { System.out.println(N); return ; }
		else if(N <= 110) { System.out.println(99); return ; }
		
		// N이 111 이상일 경우에만 연산.
		int count = 99;
		int max = N / 100;
		
		for(int i = 1 ; i <= max ; i++) {
			int tmp = i + i*10 + i*100;
			for(int cal = -4 ; cal < 5 ; cal++) {
				if(i + cal*2 < 0 || i + cal*2 > 9) continue;
				
				int tmp2 = tmp + cal*10 + cal*2;
				if(tmp2 <= N) count++;
			}
		}
		System.out.println(count);
	}
}