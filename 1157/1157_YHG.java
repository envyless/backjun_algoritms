import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		String input = scn.nextLine();
		
		int index = input.length();
		
		char[] in = new char[index];
		int[] count = new int[index];
		
		int max = 0;
		int doub = 0;
		int printIndex = 0;
		char tmp;
		
		
		tmp = input.charAt(0);
		if(tmp >= 'A' && tmp <= 'Z') {
			tmp = (char)(tmp + ('a' - 'A'));
		}
		
		in[0] = tmp;
		count[0] = 1;
		
		for(int i = 1 ; i < index ; i++) {
			tmp = input.charAt(i);
			if(tmp >= 'A' && tmp <= 'Z') {
				tmp = (char)(tmp + ('a' - 'A'));
			}
			for(int j = 0; j < i ; j++) {
				if(in[j] == tmp) {
					count[j]++;
					break;
				}
				else {
					in[i] = tmp;
					count[i] = 1;
				}
			}
		}
		
		max = count[0];
		
		for(int i = 1 ; i < index ; i++) {
			if(max < count[i]) {
				max = count[i];
				printIndex = i;
			}
			else if( max == count[i])
				doub = max;
			else // max가 최대일때는 아무것도 안해도 됨
				;
		}
		
		if(max == doub)
			System.out.println("?");
		else {
			tmp = input.charAt(printIndex);
			if(tmp >= 'a' && tmp <= 'z') {
				tmp = (char)(tmp - ('a' - 'A'));
			}
			System.out.println(tmp);
		}
			
		
	}

}
