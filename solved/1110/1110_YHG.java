import java.util.Scanner;

public class Problem_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int[] arr = new int[2];
		
		if(N < 10)
			arr[1] = N;
		else {
			arr[0] = N/10;
			arr[1] = N%10;
		}
		
		int tmp = 0;
		int count = 0;
		
		if(N == 0) {
			System.out.println(1);
			return ;
		}
		
		while(true) {
	
			tmp = arr[0] + arr[1];
			//System.out.println(arr[0] + " + " + arr[1] + " = " + tmp);
			tmp %= 10;
			
			arr[0] = arr[1];
			arr[1] = tmp;
			//System.out.println("changed.. arr[0] : " + arr[0] + " , arr[1] : "+ arr[1]);
			count++;
			
			if(N == (arr[0]*10 + tmp))
				break;
		}
		
		System.out.println(count);
	}

}
