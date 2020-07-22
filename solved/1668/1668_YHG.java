import java.util.Scanner;

public class Problem_1668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] tp = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			tp[i] = sc.nextInt();
		
		int count = 0 ;
		int h = 0;
		
		for(int i = 0 ; i < N ; i++)
			if(h < tp[i]) {
				count++;
				h = tp[i];
			}
		System.out.println(count);
		
		count = 0;
		h = 0;
		for(int i = N-1 ; i >= 0 ; i--) {
			if(h < tp[i]) {
				count++;
				h = tp[i];
			}
		}
		System.out.println(count);
	}
}