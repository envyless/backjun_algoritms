import java.util.Scanner;

public class Problem_1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int E = scn.nextInt(); // 15
		int S = scn.nextInt(); // 28
		int M = scn.nextInt(); // 19
		
		int year = 1;
		int e = 1;
		int s = 1;
		int m = 1;
		
		while(true) {
			if(e == E && s == S && m == M)
				break;
			
			e = (e+1) % 16;
			s = (s+1) % 29;
			m = (m+1) % 20;
			
			if(e == 0)
				e = 1;
			if(s == 0)
				s = 1;
			if(m == 0)
				m = 1;
			year++;
		}
		System.out.println(year);
	}
}