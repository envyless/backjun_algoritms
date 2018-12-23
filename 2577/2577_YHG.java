import java.util.Scanner;

public class Problem_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int mul = 1;
		
		for(int i = 0 ; i < 3 ; i++)
			mul *= scn.nextInt();
		
		String tmp = String.valueOf(mul);
		int[] count = new int[10];
		
		for(int i = 0 ; i < tmp.length() ; i++)
			count[tmp.charAt(i) - 48]++;
		
		for(int i = 0 ; i < 10 ; i++)
			System.out.println(count[i]);
	}
}