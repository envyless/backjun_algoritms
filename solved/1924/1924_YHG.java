import java.util.Scanner;

public class Problem_1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int X = scn.nextInt(); // ¿ù
		int Y = scn.nextInt(); // ÀÏ
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		int now = 1;
		if(X == 1)
			now = Y;
		else
			for(int i = 0; i < X-1 ; i++)
				Y += month[i];
		
		System.out.println(days[Y%7]);
	}
}