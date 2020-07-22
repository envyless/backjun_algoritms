import java.util.Scanner;

public class Problem_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ´Ü¾î °¹¼ö
		String[] insert = new String[N];
		int count = 0;
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.next();
		
		for(int i = 0 ; i < N ; i++) {
			int len = insert[i].length();
			boolean[] alpha = new boolean[26]; // a : 97 , z : 122
			for(int j = 0 ; j < len ; j++) {
				int tmp = insert[i].charAt(j) - 97;
				if(!alpha[tmp]) alpha[tmp] = true;
				else
					if(tmp != insert[i].charAt(j-1)-97) break;
				if(j == len-1) count++;
			}
		}
		System.out.println(count);
	}
}