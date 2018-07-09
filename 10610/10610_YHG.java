import java.util.Scanner;

public class Problem_10610 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String s = scn.next(); // 채널 번호
		
		int num;
		int[] len = new int[10];
		boolean checkZero = false;
		int sum = 0;
		
		for(int i = 0 ; i < s.length() ; i++) {
			num = s.charAt(i)-48;
			len[num]++;
			sum += num;
			if(num == 0)
				checkZero = true;
		}
		
		if(checkZero && sum % 3 == 0) {
			for(int i = 9 ; i >= 0 ; i--)
				for(int j = 0 ; j < len[i] ; j++)
					System.out.print(i);
		}else 
			System.out.println("-1");
	}
}