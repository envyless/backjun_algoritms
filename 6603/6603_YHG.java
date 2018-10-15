import java.util.Scanner;

public class Problem_6603 {

	static int N;
	static int[] insert;
	static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		while(true) {
			N = scn.nextInt(); // 6 ~ 13
			if(N == 0)
				return ;
			insert = new int[N];
			check = new boolean[N];
			for(int i = 0 ; i < N ; i++)
				insert[i] = scn.nextInt();
			
			// 6개 출력. 가능한 모든 경우의 수.
			dfs(0,0);
			System.out.println();
		}
	}
	public static void dfs(int index, int count) {
		if(count == 6) {
			for(int i = 0 ; i < N ; i++)
				if(check[i])
					System.out.print(insert[i] + " ");
			System.out.println();
		}
		
		for(int i = index ; i < N ; i++) {
			check[i] = true;
			dfs(i+1, count+1);
			check[i] = false;
		}
	}
}
