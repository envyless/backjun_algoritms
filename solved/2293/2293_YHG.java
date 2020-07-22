import java.util.Arrays;
import java.util.Scanner;

public class Problem_2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // 종류
		int k = scn.nextInt(); // 만들 값
		int[] insert = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++)
			insert[i] = scn.nextInt();
		Arrays.sort(insert);
		
		int[] result = new int[k+1]; // result[j] 배열은 i 번째 coin까지 사용하여 j를 만들 수 있는 가짓 수
		int[] cal = new int[k+1]; // cal[j] 배열은 i-1번째 coin까지 사용하여 j원을 만들 수 있는 가짓 수
		
		result[0] = 1;
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= k ; j++) {
				if(j < insert[i]) // 현재 만들 값보다 코인의 크기가 크면
					result[j] = cal[j]; // cal값을 result에 그대로 저장한다.
				else { // 현재 만들 값보다 코인의 크기가 작으면
					System.out.println("result["+j+"] = + cal[" + j + "] + result[" + (j-insert[i]) + "]");
					System.out.println(result[j] + " = "+ cal[j] + " + " + result[j-insert[i]]);
					result[j] = cal[j] + result[j-insert[i]]; // cal 값에 result배열 index에 코인의 값만큼 뺀 index 값을 더한다.
					System.out.println("result[" + j + "] = " + result[j]);
				}
			}
			
			System.out.println("cal[j] setting... " );
			for(int j = 1 ; j <= k ; j++)
				cal[j] = result[j]; // cal 값에 만든 result값을 갱신한다.
		}
		System.out.println(result[k]);
	}
}