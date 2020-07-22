import java.util.Scanner;

public class Problem_1072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		long X = scn.nextInt(); // ÀüÃ¼
		long Y = scn.nextInt(); // ÀÌ±ä È½¼ö
		long Z = (Y*100)/X; // ÇöÀç ½Â·ü
		
		if(Z >= 99) {
			System.out.println(-1);
			return ;
		}
		
		long start = 0;
		long end = 2*X;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long tmp = (Y+mid) * 100 / (X+mid);
			
			if(Z < tmp)
				end = mid - 1;
			else
				start = mid + 1;
		}
		System.out.println(start);
	}
}