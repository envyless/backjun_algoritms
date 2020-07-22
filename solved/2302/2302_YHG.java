import java.util.Scanner;

public class Problem_2302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // ÁÂ¼®ÀÇ ¼ö 1 ~ 40
		int M = scn.nextInt(); // VIP ÁÂ¼®ÀÇ ¼ö 0 ~ N
		int[] vip = new int[M]; // VIP ÁÂ¼® ¹øÈ£
		int[] count = new int[M+1]; // VIP Á¦¿Ü ÁÂ¼® °¹¼ö
		int result = 1;
		
		for(int i = 0 ; i< M ; i++)
			vip[i] = scn.nextInt()-1;
		
		int check = 0;
		int index = 0;
		for(int i = 0 ; i < N ; i++) {
			if(index < M && i == vip[index]) {
				count[index] = check;
				check = 0;
				index++;
			}
			else
				check++;
		}
		count[M] = check;
		
		for(int i = 0 ; i <= M ; i++) {
			if(count[i] == 0 || count[i] == 1) {
				result *= 1;
				continue;
			}
			if(count[i] == 2) {
				result *= 2;
				continue;
			}
			
			int first = 1;
			int second = 2;
			int tmp = 0;
			for(int j = 3; j <= count[i] ; j++) {
				tmp = first + second;
				first = second;
				second = tmp;
			}
			result *= tmp;
		}	
		System.out.println(result);
	}
}