import java.util.Scanner;

public class Problem_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		
		int[] input = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++)
			input[i] = scn.nextInt();
		
		int[] count = new int[N+1];
		int max = 0;
		
		for(int i = 1 ; i < N+1 ; i++) {
			for(int j = 0 ; j < i ; j++) {
				System.out.println("i, j >>> " + i + " : " + j +"  input[i] : " + input[i] + " , input[j] : " + input[j] + " , count[i] : count[j] :: " + count[i] + " : " + count[j]);
				if(input[i] > input[j] && count[i] < count[j]+1) {
					count[i] = count[j]+1;
					System.out.println("insert... count[i] : " +count[i]);
				}
			}
		}
		
		max = count[1];
		
		for(int i = 2 ; i < N+1 ; i++)
			if(max < count[i])
				max = count[i];
		
		System.out.println(max);

	}

}
