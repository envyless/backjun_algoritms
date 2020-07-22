import java.util.Scanner;

public class Problem_6359 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt(); // 테스트 케이스
		
		for(int i = 0 ; i < T ; i++) {
			int nowRoom = scn.nextInt();
			boolean[] open = new boolean[nowRoom+1];
		
			int test = 1;
			
			while(test <= nowRoom) {
				int index = 1;
				
				while(index <= nowRoom) {
					if((index*test) <= nowRoom) {
						if(open[index*test])
							open[index*test] = false;
						else
							open[index*test] = true;
						
					}
					index++;
				}
				test++;
			}
			
			int count = 0;
			for(int k = 1 ; k <= nowRoom ; k++)
				if(open[k])
					count++;
			
			System.out.println(count);
		}	
	}
}