import java.util.Scanner;

public class Problem_2355 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		long N = scn.nextLong(); // ���� ��
		long M = scn.nextLong(); // �� ��

		if(N > M) {
			long tmp = N;
			N = M;
			M = tmp;
		}
		N--;
		long sum1 = (N+1)*N / 2;
		long sum2 = (M+1)*M / 2;
		System.out.println(sum2 - sum1);
	}
}