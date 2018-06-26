import java.util.Scanner;

public class Problem_2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// 낮에 올라갈 미터
		int A = scn.nextInt();
		// 밤에 떨어질 미터
		int B = scn.nextInt();
		// 나무 막대의 높이
		int V = scn.nextInt();
		// 일수
		int count = (V-A) / (A-B);
		int tmp = (V-A) % (A-B);
		
		if(tmp != 0)
			count++;
		count++;
		System.out.println(count);
	}

}
