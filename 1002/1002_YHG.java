import java.util.Scanner;

public class Problem_1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int x1 = scn.nextInt();
			int y1 = scn.nextInt();
			int r1 = scn.nextInt();
			int x2 = scn.nextInt();
			int y2 = scn.nextInt();
			int r2 = scn.nextInt();
			
			
			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) { // x,y 좌표가 같을 때 거리가 같으면 무한대
					System.out.println(-1);
					continue;
				}
				else { // x,y 좌표가 같을 때 거리가 다르면 0
					System.out.println(0);
					continue;
				}
			}
			
			if(r1 == 0 || r2 == 0) // 거리 하나가 0 일 때.
				if(x1 != x2 || y1 != y2) { // 좌표가 다름.
					System.out.println(1);
					continue;
				}
			
			//만날수 없거나, 한 점에서 만나거나, 두 점에서 만남.
			int len = (int)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			int people = (int)Math.pow(r1+r2, 2);
			int tmp = (int)Math.pow(Math.abs(r1-r2), 2);
			
			if(len == people) System.out.println(1);
			else if(len > people) System.out.println(0);
			else
				if(tmp == len) System.out.println(1); // 내접
				else if(tmp < len) System.out.println(2);
				else System.out.println(0); // 포함
		}
	}
}