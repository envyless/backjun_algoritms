import java.util.Scanner;

public class Problem_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 사람의 수
		int[][] insert = new int[N][2];
		int[] value = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			insert[i][0] = scn.nextInt();
			insert[i][1] = scn.nextInt();
		}
		
		for(int i = 0 ; i < N ; i++) {
			int count = 1;
			for(int j = 0 ; j < N ; j++) {
				if(insert[i][0] < insert[j][0] && insert[i][1] < insert[j][1])
					count++;
			}
			value[i] = count;
		}
		
		for(int i = 0 ; i < N ; i++)
			System.out.print(value[i] + " ");
	}
}