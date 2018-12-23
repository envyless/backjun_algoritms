import java.util.Scanner;

public class Problem_2490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		char[] value = {'E', 'A', 'B', 'C', 'D'}; // ¸ð µµ °³ °É À·
		int index = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 4 ; j++)
				if(scn.nextInt() == 0)
					index++;
			System.out.println(value[index]);
			index = 0;
		}
	}
}