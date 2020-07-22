import java.util.Scanner;

public class Problem_1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String name = scn.nextLine();
		int[] al = new int[26];
		char[] alpha = new char[26];
		String result = "";
		
		for(int i = 0 ; i < name.length() ; i++)
			al[name.charAt(i) - 'A']++;
		for(int i = 0 ; i < 26 ; i++)
			alpha[i] = (char)('A' + i);
		
		int check = 0;
		int oddIndex = 1000;
		for(int i = 0 ; i < 26 ; i++)
			if(al[i] % 2 == 1) {
				check++;
				oddIndex = i;
			}
		
		if(check >= 2) {
			System.out.println("I'm Sorry Hansoo");
			return ;
		}
		
		for(int i = 0 ; i < 26 ; i++) {
			if(al[i] == 0)
				continue;
			int tmp = al[i] / 2;
			for(int j = 0 ; j < tmp ; j++)
				result += alpha[i];
		}
		
		if(oddIndex != 1000)
			result += alpha[oddIndex];
		
		for(int i = 25 ; i >= 0 ; i--) {
			if(al[i] == 0)
				continue;
			int tmp = al[i] / 2;
			for(int j = 0 ; j < tmp ; j++)
				result += alpha[i];
		}
		System.out.println(result);
	}
}