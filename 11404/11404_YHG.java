import java.util.Scanner;

public class Problem_11404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt(); // 도시의 수
		int m = scn.nextInt(); // 버스의 수
		int max = 123456789;
		
		int[][] city = new int[n+1][n+1];
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++)
				city[i][j] = max;
		}
		
		for(int i = 0 ; i < m ; i++) {
			int start = scn.nextInt();
			int end = scn.nextInt();
			int cost = scn.nextInt();
			
			if(city[start][end] > cost)
				city[start][end] = cost;		
		}

		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(i == j)
						continue;
					if(city[i][j] > city[i][k] + city[k][j])
						city[i][j] = city[i][k] + city[k][j];
				}
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(i == j || city[i][j] == max)
					System.out.print(0 + " ");
				else
					System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}