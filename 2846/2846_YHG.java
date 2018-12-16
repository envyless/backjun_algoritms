import java.util.Scanner;

public class Problem_2846 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int[] insert = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			int start = insert[i];
			int tmp = insert[i];
			int end = insert[i];
			for(int j = i+1 ; j < N ; j++) {
				if(tmp < insert[j]) {
					end = insert[j];
					tmp = insert[j];
				}
				else
					break;
			}
			
			int value = end - start;
			if(max < value)
				max = value;
		}
		System.out.println(max);
	}
}