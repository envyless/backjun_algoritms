import java.util.Scanner;

public class Problem_1107 {

	static Scanner scn = new Scanner(System.in);
	
	static int N = scn.nextInt(); // ä�� ��ȣ
	static int M = scn.nextInt(); // ���峭 ��ư ����
	static boolean[] broken = new boolean[10]; // ���峭 ��ư ��ȣ true
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0 ; i < M ; i++)
			broken[scn.nextInt()] = true;
		
		int onlyPM = Math.abs(N - 100);
		int count = onlyPM;
		
		int upper = N;
		int lower = N;
		
		while(upper <= 999900) {
			
			if(lower > -1 && check(lower)) {
				count = String.valueOf(lower).length() + Math.abs(N - lower);
				break;
			}
			
			if(check(upper)) {
				count = String.valueOf(upper).length() + Math.abs(upper - N);
				break;
			}
			
			upper++;
			lower--;
		}
		
		if(count > onlyPM)
			count = onlyPM;
		
		System.out.println(count);
	}
	
	static boolean check(int number) {
		char[] tmp = String.valueOf(number).toCharArray();
		
		for(int i = 0 ; i < tmp.length ; i++)
			if(broken[tmp[i]-48])
				return false;
		return true;
	}
}