import java.util.Scanner;

public class Problem_11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int A = scn.nextInt(); // 배열 크기
		int[] insert = new int[A+1];
		
		for(int i = 1 ; i < A+1 ; i++)
			insert[i] = scn.nextInt();
		
		int max = -1;
		int[] sum = new int[A+1];
		
		for(int i = 1 ; i < A+1 ; i++) {
			for(int j = 0 ; j < i ; j++)
				if(insert[i] > insert[j]) 
					sum[i] = Math.max(sum[j] + insert[i], sum[i]);
			max = Math.max(sum[i], max);
		}
		
		System.out.println(max);
	}

}
