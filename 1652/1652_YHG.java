import java.util.Scanner;

public class Problem_1652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 방의 크기
		char[][] insert = new char[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			String tmp = scn.next();
			for(int j = 0 ; j < N ; j++) {
				insert[i][j] = tmp.charAt(j);
			}
		}	
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			int check = 0;
			for(int j = 0 ; j < N ; j++) {
				if(insert[i][j] == '.') {
					check++;
					if(j == N-1)
						if(check >= 2)
							count++;
				}
				else {
					if(check >= 2)
						count++;
					check = 0;
				}
			}
		}
		int count2 = 0;
		for(int i = 0 ; i < N ; i++) {
			int check = 0;
			for(int j = 0 ; j < N ; j++) {
				if(insert[j][i] == '.') {
					check++;
					if(j == N-1)
						if(check >= 2) 
							count2++;
				}
				else {
					if(check >= 2) 
						count2++;
					check = 0;
				}
			}
		}
		System.out.println(count + " " + count2);
	}
}