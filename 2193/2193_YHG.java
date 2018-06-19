import java.util.Scanner;

public class Problem_2193 {

	static Scanner scn = new Scanner(System.in);

	static int N = scn.nextInt(); // 2진 자리수
	static long count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] binary = new long[3];
		
		binary[0] = 1;
		binary[1] = 0;
		binary[2] = 1;
		
		pib(binary, 0);
		
	}
	
	static void pib(long[] binary, int i) {
		if(i+1 == N)
			System.out.println(binary[2]);
		else {
			if(binary[1] == 0) {
				binary[1] = 1;
				pib(binary,++i);
			}else {
				binary[0] = binary[1];
				binary[1] = binary[2];
				binary[2] = binary[0] + binary[1];
				pib(binary,++i);
			}
		}
	}
}
