import java.util.Scanner;

public class Problem_1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String insert = scn.nextLine();
		int[] value = new int[10];
		
		for(int i = 0 ; i < insert.length() ; i++)
			value[insert.charAt(i) - 48]++;
		
		for(int i = 9 ; i >= 0 ; i--)
			for(int j = 0 ; j < value[i] ; j++)
				System.out.print(i);
	}
}