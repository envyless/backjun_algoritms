import java.util.Scanner;

public class Problem_8320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 정사각형의 갯수
		boolean[][] check = new boolean[N+1][N+1];
		int count = N; // 1x1 ~ 1xN
		
		for(int i = 1 ; i < N+1 ; i++) {
			check[1][i] = true;
			check[i][1] = true;
		}
		
		for(int i = 2 ; i < N+1 ; i++) {
			int tmp = N;
			int index = 1;
			tmp -= i;
			
			while(tmp - i >= 0) {
				tmp -= i;
				index++;
				if(check[i][index] || check[index][i]) 
					continue;
				
				count++;
				check[i][index] = true;
				check[index][i] = true;
			}
		}
		System.out.println(count);
	}
}