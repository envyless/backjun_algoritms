import java.util.Scanner;

public class Problem_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 수열의 크기
		int[] insert = new int[N];
		int[] count = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		int len = 0;
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < i ; j++) 
				if(insert[i] < insert[j] && count[i] < count[j] + 1) {
					count[i] = count[j] + 1;
					if(len < count[i])
						len = count[i];
				}
		
		System.out.println(len+1);
	}
}