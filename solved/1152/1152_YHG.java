import java.util.Scanner;

public class Problem_1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String insert = scn.nextLine();
		int len = insert.length();
		int count = 1;
		int blan = 0;
		for(int i = 1 ; i < len ; i++) {
			int tmp = insert.charAt(i);
			if(tmp == 32) {
				if(insert.charAt(i-1) == 32) {
					blan++;
					continue;
				}
				if(i == len-1)
					break;
				count++;
			}
		}
		
		if(blan == len-1)
			count--;
		System.out.println(count);
	}
}