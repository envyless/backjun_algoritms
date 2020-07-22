import java.util.Scanner;

public class Problem_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 집의 수
		int[][] color = new int[N][3]; // 빨 초 파 비용
		int[][] value = new int[N][3];
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < 3 ; j++)
				color[i][j] = scn.nextInt();
		
		value[0][0] = color[0][0];
		value[0][1] = color[0][1];
		value[0][2] = color[0][2];
		
		for(int i = 1 ; i < N ; i++) {
			value[i][0] = Math.min(value[i-1][1], value[i-1][2]) + color[i][0];
			value[i][1] = Math.min(value[i-1][0], value[i-1][2]) + color[i][1];
			value[i][2] = Math.min(value[i-1][0], value[i-1][1]) + color[i][2];
		}
		
		int min = Math.min(value[N-1][0], Math.min(value[N-1][1], value[N-1][2]));
		System.out.println(min);
	}
}