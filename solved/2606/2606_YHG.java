import java.util.Scanner;

public class Problem_2606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 컴퓨터 갯수
		int L = scn.nextInt(); // 연결 수
		int[][] insert = new int[L][2];
		boolean[] check = new boolean[N+1];
		int count = 0;
		
		for(int i = 0 ; i < L ; i++) {
			insert[i][0] = scn.nextInt();
			insert[i][1] = scn.nextInt();
			if(insert[i][0] == 1) 
				check[insert[i][1]] = true;
			if(insert[i][1] == 1)
				check[insert[i][0]] = true;
		}
		check[1] = true;
		
		int chk = 0;
		while(true) {
			int same = 0;
			for(int i = 1 ; i < N+1 ; i++) {
				if(check[i]) 
					for(int j = 0 ; j < L ; j++) {
						if(insert[j][0] == i) {
							check[insert[j][1]] = true;
							same++;
						}
						if(insert[j][1] == i) {
							check[insert[j][0]] = true;
							same++;
						}
					}
			}
			
			if(chk == same)
				break;
			else
				chk = same;
		}
		
		for(int i = 2 ; i < N+1 ; i++)
			if(check[i])
				count++;
		
		System.out.println(count);	
	}
}