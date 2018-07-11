import java.util.Scanner;

public class Problem_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 남은 빵의 갯수. 1 이상 1000 이하.
		int[] insert = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++)
			insert[i] = scn.nextInt();
		
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 1 ; j < i ; j++)
				insert[i] = Math.max(insert[i] , insert[i-j] + insert[j]);}
			
		System.out.println(insert[N]);
	}
}
