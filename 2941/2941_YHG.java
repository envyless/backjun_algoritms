import java.util.Scanner;

public class Problem_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String str = scn.nextLine();
		int len = str.length();
		// c= ,c- , dz=, d-, lj, nj, s= ,z=
		int count = 0;
		
		for(int i = 0 ; i < len ; i++) {
			char now = str.charAt(i);
			
			count++;
			if(i+1 < len) {
				if(now == 'c') {
					if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-')
						i++;
				}
				else if(now == 's' || now == 'z') {
					if(str.charAt(i+1) == '=')
						i++;
				}
				else if(now == 'l' || now == 'n') {
					if(str.charAt(i+1) == 'j')
						i++;
				}
				else if(now =='d') {
					if(str.charAt(i+1) == '-')
						i++;
					else
						if(i+2 < len)
							if(str.charAt(i+1) == 'z' && str.charAt(i+2) == '=')
								i += 2;
				}
			}
		}
		System.out.println(count);
	}
}