import java.util.Scanner;

public class Problem_1057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // ÃÑ »ç¶÷ ¼ö  
		int[] insert = new int[N+4]; 
		for(int i = 0 ; i < N ; i++)
			insert[i] = i+1;
		
		int a = scn.nextInt(); // ±èÁö¹Î
		int b = scn.nextInt(); // ÀÓÇÑ¼ö
		
		if(a > b) { // Ç×»ó a¸¦ ³·Àº ¼ö·Î.
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int round = 0;
		boolean finish = false;
		while(true) {
			int index = 0;
			round++;
			for(int i = 0 ; i < N ; i+=2) {
				if(insert[i]  == a && insert[i+1] == b) {
					finish = true;
					break;
				}
				
				if(insert[i]  == a || insert[i+1] == a) {
					insert[index++] = a;
					insert[index] = 0;
				} else if(insert[i]  == b || insert[i+1] == b) {
					insert[index++] = b;
					insert[index] = 0;
				} else {
					insert[index++] = insert[i];
					insert[index] = 0;
				}
				
			}
			
			if(finish) {
				System.out.println(round);
				break;
			}
			if(N % 2 != 0)
				N++;
			N = N/2;
		}
	}
}