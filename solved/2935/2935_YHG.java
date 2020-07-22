import java.util.Scanner;

public class Problem_2935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String first = scn.nextLine();
		String op = scn.nextLine();
		String second = scn.nextLine();
		
		String result = "";
		
		if(first.length() < second.length()) {
			String tmp = first;
			first = second;
			second = tmp;
		}
		if(op.equals("*")) {
			result = first;
			
			for(int i = 1 ; i < second.length() ; i++)
				result += "0";
		}
		else {
			int lenF = first.length();
			int lenS = second.length();
			if(lenF == lenS) {
				result = "2";
				
				for(int i = 1 ; i < lenF ; i++)
					result += "0";
			}
			else {
				for(int i = 0 ; i < lenF - lenS ; i++)
					result += first.charAt(i);
				
				for(int i = 0 ; i < lenS ; i++)
					result += second.charAt(i); 
			}
		}
		System.out.println(result);
	}
}