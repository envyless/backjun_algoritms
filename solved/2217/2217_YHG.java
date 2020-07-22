import java.util.Arrays;
import java.util.Scanner;

public class Problem_2217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 로프의 수
		int[] insert = new int[N];
		int[] sum = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		Arrays.sort(insert);
		
		//k개 로프 사용해서 w를 들 때, 각 로프는 w/k의 하중이 걸림.
		sum[N-1] = insert[N-1];
		int min = sum[N-1];
		int k = 1;
		int tmp = 0;
		int w = sum[N-1] * k;
		
		for(int i = N-2; i >= 0 ; i--) {
			if(min > insert[i])
				min = insert[i];
			sum[i] = insert[i] + sum[i+1];
			k++;
			tmp = sum[i] / k;
			if(tmp > min)
				tmp = min;
			
			if(w < tmp * k)
				w = tmp * k;
		}
		System.out.println(w);
	}
}