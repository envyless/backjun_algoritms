import java.util.Scanner;

public class Problem_1965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 배열 크기
		int[] insert = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++)
			insert[i] = scn.nextInt();
		
		int[] len = new int[N+1];
		int max = 1;
		
		for(int i = 1 ; i < N+1 ; i++)
			len[i] = 1;
		
		for(int i = 1 ; i < N+1 ; i++) {
			
			for(int j = 0 ; j < i ; j++) {
				if(insert[i] > insert[j] && len[i] < len[j]+1)
					len[i] = len[j] +1;
				if(len[i] > max) max = len[i];
			}
		}
	
		System.out.println(max);
	}
}
