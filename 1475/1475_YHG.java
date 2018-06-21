import java.util.Scanner;

public class Problem_1475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		
		String number = Integer.toString(N);
		// 0 ~ 9 
		int[] count = new int[10];
		
		for(int i = 0 ; i < number.length() ; i++) {
			int tmp = number.charAt(i) - 48;
			
			if(tmp == 6 || tmp == 9) {
				// 6이나 9가 들어왔을 때, 작은 값의 count를 올린다.
				if(count[6] > count[9])
					count[9]++;
				else
					count[6]++;
			}else 
				count[tmp]++;
		}
		int max = 0;
		for(int i = 0 ; i < 10 ; i++) {
			if(max < count[i])
				max = count[i];
		}
		System.out.println(max);
	}
}
