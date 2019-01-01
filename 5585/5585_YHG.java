import java.util.Scanner;

public class Problem_5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int insert = 1000 - scn.nextInt();
		int[] coin = { 500, 100, 50, 10, 5, 1 };
		int count = 0;
		
		for(int i = 0 ; i < coin.length ; i++) {
			int tmp = insert / coin[i];
			insert -= coin[i] * tmp;
			count += tmp;
			
			if(insert == 0)
				break;
		}
		System.out.println(count);
	}
}