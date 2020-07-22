import java.util.Scanner;

public class Problem_1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int x = scn.nextInt(); // 현재 위치
		int y = scn.nextInt(); // (x,y)
		int w = scn.nextInt(); // 직사각형
		int h = scn.nextInt(); // (w,h)
		
		int resX = 0;
		int resY = 0;
		if(x < w-x)
			resX = x;
		else
			resX = w-x;
		
		if(y < h-y)
			resY = y;
		else
			resY = h-y;
		
		if(resX > resY)
			resX = resY;
		
		System.out.println(resX);
	}
}