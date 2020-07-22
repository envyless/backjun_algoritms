import java.util.Arrays;
import java.util.Scanner;

public class Problem_2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 카드의 수
		int M = scn.nextInt(); // 맞춰야하는 수
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		Arrays.sort(insert);
		int sum = 0;
		int result = 0;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				for(int k = j+1 ; k < N ; k++) {
					sum = insert[i] + insert[j] + insert[k];
					if(sum > M) // 그 다음 k는 더 큰 수 이기 때문.
						break;
					if(sum == M) {
						System.out.println(M);
						return ;
					}
					if(result < sum)
						result = sum;
				}
			}
		}
		System.out.println(result);
	}
}