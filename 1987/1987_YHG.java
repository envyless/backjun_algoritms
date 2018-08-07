import java.util.Scanner;

public class Problem_1987 {
	static Scanner scn = new Scanner(System.in);
	
	static int R = scn.nextInt(); // 행(세로) 1 ~ 20
	static int C = scn.nextInt(); // 열(가로) 1 ~ 20
	static char[][] insert = new char[R][C];
	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] check = new boolean[26]; // 'A' = 65
		
		for(int i = 0 ; i < R ; i++) {
			String tmp = scn.next();
			for(int j = 0 ; j < tmp.length() ; j++)
				insert[i][j] = tmp.charAt(j);	
		}
		
		// 0,0 부터 시작.
		dfs(check,0,0,0);
		System.out.println(max);
	}
	
	public static void dfs(boolean[] chk, int x, int y, int count) {
		int[] tmpX = { -1 , 0 , 1 , 0 };
		int[] tmpY = { 0 , -1 , 0 , 1 };
		int nowCount = count;
		chk[insert[y][x] - 65] = true;
		nowCount++;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nowX = x + tmpX[i];
			int nowY = y + tmpY[i];
			if(nowX >= 0 && nowY >= 0 && nowX < C && nowY < R) {
				if(!chk[insert[nowY][nowX] - 65]) {
					chk[insert[nowY][nowX] - 65] = true;
					dfs(chk,nowX,nowY,nowCount);
					chk[insert[nowY][nowX] - 65] = false;
				}
			}
		}	
		if(max < nowCount) max = nowCount;
	}
}