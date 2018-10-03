import java.util.Scanner;

public class Problem_2512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 도시의 수
		int[] insert = new int[N];
		long sum = 0;
		int high = 0;
		for(int i = 0 ; i < N ; i++) {
			insert[i] = scn.nextInt();
			if(high < insert[i])
				high = insert[i];
			sum += insert[i];
		}
		long M = scn.nextLong();
		
		if(sum <= M) {
			System.out.println(high);
			return ;
		}
		
		long start = 0;
		long end = high;
		long result = 0;
		while(start <= end) {
			long tmp = 0;
			long mid = (start + end) / 2;
			
			for(int i = 0 ; i < N ; i++) {
				if(insert[i] > mid)
					tmp += mid;
				else
					tmp += insert[i];
			}
			
			if(tmp > M)
				end = mid - 1;
			else {
				start = mid + 1;
				if(result < mid)
					result = mid;
			}
		}
		System.out.println(result);
	}
}