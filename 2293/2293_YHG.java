import java.util.Arrays;
import java.util.Scanner;

public class Problem_2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt(); // ����
		int k = scn.nextInt(); // ���� ��
		int[] insert = new int[n+1];
		
		for(int i = 1 ; i <= n ; i++)
			insert[i] = scn.nextInt();
		Arrays.sort(insert);
		
		int[] result = new int[k+1]; // result[j] �迭�� i ��° coin���� ����Ͽ� j�� ���� �� �ִ� ���� ��
		int[] cal = new int[k+1]; // cal[j] �迭�� i-1��° coin���� ����Ͽ� j���� ���� �� �ִ� ���� ��
		
		result[0] = 1;
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= k ; j++) {
				if(j < insert[i]) // ���� ���� ������ ������ ũ�Ⱑ ũ��
					result[j] = cal[j]; // cal���� result�� �״�� �����Ѵ�.
				else { // ���� ���� ������ ������ ũ�Ⱑ ������
					System.out.println("result["+j+"] = + cal[" + j + "] + result[" + (j-insert[i]) + "]");
					System.out.println(result[j] + " = "+ cal[j] + " + " + result[j-insert[i]]);
					result[j] = cal[j] + result[j-insert[i]]; // cal ���� result�迭 index�� ������ ����ŭ �� index ���� ���Ѵ�.
					System.out.println("result[" + j + "] = " + result[j]);
				}
			}
			
			System.out.println("cal[j] setting... " );
			for(int j = 1 ; j <= k ; j++)
				cal[j] = result[j]; // cal ���� ���� result���� �����Ѵ�.
		}
		System.out.println(result[k]);
	}
}