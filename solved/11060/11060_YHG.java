import java.util.Scanner;

public class Problem_11060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 길이 1 ~ 1,000
		int[] insert = new int[N];
		int INF = 99999999;
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt(); // 입력 값 0 ~ 100
		
		int[] count = new int[N];
		
		for(int i = 1 ; i < N ; i++)
			count[i] = INF;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 1 ; j <= insert[i] ; j++) {
				int tmp = i+j;
				if(tmp >= N)
					continue;
				
				if(count[tmp] == INF)
					count[tmp] = count[i] + 1;
				else
					if(count[tmp] > count[i] + 1)
						count[tmp] = count[i] + 1;
			}
		}
		
		if(count[N-1] >= INF)
			count[N-1] = -1;
		
		System.out.println(count[N-1]);
	}
}