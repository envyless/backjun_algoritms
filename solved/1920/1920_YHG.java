import java.util.Arrays;
import java.util.Scanner;

public class Problem_1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정점의 수
		int[] value = new int[N];
		for(int i = 0 ; i < N ; i++)
			value[i] = scn.nextInt();
		Arrays.sort(value);
		
		int M = scn.nextInt();
		int[] insert = new int[M];
		for(int i = 0 ; i < M ; i++)
			insert[i] = scn.nextInt();
		
		for(int i = 0 ; i < M ; i++) {
			int tmp = insert[i];
			int start = 0;
			int end = N-1;
			boolean check = false;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				if(value[mid] == tmp) {
					check = true;
					System.out.println(1);
					break;
				}
				
				if(tmp > value[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
			if(!check)
				System.out.println(0);
		}
	}
}