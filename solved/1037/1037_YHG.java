import java.util.Arrays;
import java.util.Scanner;

public class Problem_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ¾à¼ö °¹¼ö
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		Arrays.sort(insert);
		
		int result = insert[0] * insert[N-1];
		
		System.out.println(result);
	}

}