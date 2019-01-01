import java.util.Scanner;

public class Problem_4504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int point = scn.nextInt();
		
		while(true) {
			int tmp = scn.nextInt();
			
			if(tmp == 0)
				break;
			
			if(tmp % point == 0)
				System.out.println(tmp + " is a multiple of " + point + ".");
			else
				System.out.println(tmp + " is NOT a multiple of " + point + ".");
		}
	}
}