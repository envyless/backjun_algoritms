import java.util.Scanner;

public class Problem_1032 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 파일의 수
		String[] insert = new String[N];
		scn.nextLine();
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextLine();
		
		int len = insert[0].length();
		boolean[] check = new boolean[len];
		String result = "";
		
		for(int i = 1 ; i < N ; i++)
			for(int j = 0 ; j < len ; j++)
				if(insert[0].charAt(j) != insert[i].charAt(j))
					check[j] = true; 
		
		for(int i = 0 ; i < len ; i++) {
			if(!check[i])
				result += insert[0].charAt(i);
			else
				result += "?";
		}
		System.out.println(result);
	}
}