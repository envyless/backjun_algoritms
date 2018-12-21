import java.util.Arrays;
import java.util.Scanner;

public class Problem_11656 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String insert = scn.nextLine();
		int len = insert.length();
		String[] result = new String[len];
		result[0] = insert;
		
		int index = 1;
		for(int i = 0 ; i < len-1 ; i++) {
			char tmp = insert.charAt(0);
			insert = insert.replaceFirst(String.valueOf(tmp), "");
			result[index++] = insert;;
		}
		
		Arrays.sort(result);
		
		for(int i = 0 ; i < len ; i++)
			System.out.println(result[i]);
	}
}