import java.util.Scanner;

public class Problem_2960 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 범위 A
		int K = scn.nextInt(); // 범위 B
		int count = 0;
		
		int[] insert = new int[N+1]; // 2부터 N까지.
		
		for(int i = 0 ; i < N+1 ; i++)
			insert[i] = i;
		
		for(int i = 2 ; i < N+1 ; i++) {
			int tmp = 0;
			if(insert[i] != 0) {
				tmp = insert[i];
				insert[i] = 0;
				count++;
				if(count == K) {
					System.out.println(tmp);
					break;
				}
			}
			
			if(tmp != 0) {
				int chk = 2;
				int tmp2 = 0;
				while(true) {
					if(tmp*chk > N) break;
					if(insert[tmp*chk] != 0) {
						tmp2 = insert[tmp*chk];
						insert[tmp*chk] = 0;
						chk++;
						count++;
						if(count == K) {
							System.out.println(tmp2);
							break;
						}
					}else
						chk++;
				}
				if(count == K)
					break;
			}
		}
	}
}
