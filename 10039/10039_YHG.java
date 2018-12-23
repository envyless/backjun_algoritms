import java.util.Scanner;

public class Problem_10039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 0 ; i < 5 ; i++) {
			int tmp = scn.nextInt();
			
			if(tmp < 40)
				tmp = 40;
			sum += tmp;
		}
		System.out.println(sum/5);
	}
}