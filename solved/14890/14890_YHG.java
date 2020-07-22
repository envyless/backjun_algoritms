import java.util.Scanner;

public class Problem_14890 {

	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // N x N
		int L = scn.nextInt(); // 경사로 길이
		
		int[][] insert = new int[N][N];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				insert[i][j] = scn.nextInt();
		boolean[][] w;
		
		// 가로 확인
		for(int i = 0 ; i < N ; i++) {
			boolean check = false;
			w = new boolean[N][N];
			for(int j = 0 ; j < N-1 ; j++) {
				int next = j+1;
				
				if(insert[i][j] == insert[i][next]) // 같으면 패스
					continue;
				if(insert[i][j] < insert[i][next] && insert[i][j]+1 != insert[i][next]) {
					check = true;
					break;
				}
				if(insert[i][j] > insert[i][next] && insert[i][j]-1 != insert[i][next]) {
					check = true;
					break;
				}
				
				// 경사로 확인
				if(insert[i][j]-1 == insert[i][next]) { // 1 작아지면
					for(int index = 0 ; index < L ; index++) {
						if(next + index >= N || insert[i][next] != insert[i][next+index] || w[i][next+index]) {
							check = true;
							break;
						}
						w[i][next+index] = true;
						if(L != 1)
							j++;
					}
					if(check)
						break;
				}
				next = j+1;
				if(next >= N)
					break;
				if(insert[i][j]+1 == insert[i][next]) { // 1 커지면
					for(int index = 0 ; index < L ; index++) {
						if(j-index < 0 || insert[i][j] != insert[i][j-index] || w[i][j-index]) {
							check = true;
							break;
						}
						w[i][j-index] = true;
					}
					if(check)
						break;
				}
			}
			if(!check)
				count++;
		}
		
		// 세로 확인
		for(int j = 0 ; j < N ; j++) {
			boolean check = false;
			w = new boolean[N][N];
			for(int i = 0 ; i < N-1 ; i++) {
				int next = i+1;
				
				if(insert[i][j] == insert[next][j]) // 같으면 패스
					continue;
				if(insert[i][j] < insert[next][j] && insert[i][j]+1 != insert[next][j]) {
					check = true;
					break;
				}
				if(insert[i][j] > insert[next][j] && insert[i][j]-1 != insert[next][j]) {
					check = true;
					break;
				}
				
				// 경사로 확인
				if(insert[i][j]-1 == insert[next][j]) { // 1 작아지면
					for(int index = 0 ; index < L ; index++) {
						if(next + index >= N || insert[next][j] != insert[next+index][j] || w[next+index][j]) {
							check = true;
							break;
						}
						w[next+index][j] = true;
						if(L != 1)
							i++;
					}
					if(check)
						break;
				}
				next = i+1;
				if(next >= N)
					break;
				if(insert[i][j]+1 == insert[next][j]) { // 1 커지면
					for(int index = 0 ; index < L ; index++) {
						if(i-index < 0 || insert[i][j] != insert[i - index][j] || w[i - index][j]) {
							check = true;
							break;
						}
						w[i - index][j] = true;
					}
					if(check)
						break;
				}
			}
			if(!check)
				count++;
		}
		System.out.println(count);
	}	
}