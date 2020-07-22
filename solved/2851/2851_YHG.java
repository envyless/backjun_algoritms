import java.util.Scanner;

public class Problem_2851 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int[] sum = new int[10];
		sum[0] = scn.nextInt();
		
		for(int i = 1 ; i < 10 ; i++) 
			sum[i] = sum[i-1] + scn.nextInt();

		int[] min = new int[10];
		for(int i = 0 ; i < 10 ; i++) {
			if(sum[i] == 100) {
				System.out.println(100);
				return ;
			}
			
			if(sum[i] < 100)
				min[i] = 100 - sum[i];
			else
				min[i] = sum[i] - 100;
		}

		int result = 1000;
		int index = 0;
		
		for(int i = 0 ; i < 10 ; i++) {
			if(result > min[i]) {
				result = min[i];
				index = i;
			}else if(result == min[i]){
				index = i;
			}
		}
		System.out.println(sum[index]);
	}
}