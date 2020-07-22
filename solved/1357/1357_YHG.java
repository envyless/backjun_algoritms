import java.util.Scanner;

public class Problem_1357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String[] insert = new String[2];
		
		insert[0] = scn.next();
		insert[1] = scn.next();
		
		for(int index = 0 ; index < 2; index++) {
			String tmp = "";
			for(int i = insert[index].length()-1 ; i >= 0 ; i--) {
				String save = "";
				save += insert[index].charAt(i);
				if(insert[index].charAt(i) == '0') {
					if(tmp.length() == 0)
						continue;
					else
						tmp += save;
				}
				else
					tmp += save;
			}
			insert[index] = tmp;
		}
		
		int integerTmp = Integer.parseInt(insert[0]) + Integer.parseInt(insert[1]);
		String result = String.valueOf(integerTmp);
		
		String tmp = "";
		for(int i = result.length()-1 ; i >= 0 ; i--) {
			String save = "";
			save += result.charAt(i);
			if(result.charAt(i) == '0') {
				if(tmp.length() == 0)
					continue;
				else
					tmp += save;
			}
			else
				tmp += save;
		}
		System.out.println(tmp);
	}
}