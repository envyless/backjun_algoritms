import java.util.Scanner;
import java.util.ArrayList;


public class Problem_1890 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		// 게임 판의 크기 
		int N = scn.nextInt();
		ArrayList<Integer>[] insert = new ArrayList[N];
		long[][] arycount = new long[N][N];
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = new ArrayList<Integer>();
		// 입력 받기
		for(int i = 0 ; i < N ; i++) 
			for(int j = 0 ; j < N ; j++) 
				insert[i].add(scn.nextInt());
			
		arycount[0][0] = 1;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(insert[i].get(j) == 0)
					continue;
				if(i == N-1 && j == N-1)
					break;
				if(i + insert[i].get(j) < N)
					arycount[i+insert[i].get(j)][j] = arycount[i][j] + arycount[i+insert[i].get(j)][j];
				if(j + insert[i].get(j) < N)
					arycount[i][j+insert[i].get(j)] = arycount[i][j] + arycount[i][j+insert[i].get(j)];
			}
		}
		System.out.println(arycount[N-1][N-1]);
	}
}
