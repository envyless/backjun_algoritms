import java.util.Scanner;

public class Problem_3054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String insert = sc.next();
		int index = insert.length();
		char[] alpha = new char[index];
		
		for(int i = 0 ; i < index ; i++)
			alpha[i] = insert.charAt(i);
		
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 1 ; j < index+1 ; j++) {
				if(i == 0 || i == 4)
					if(j % 3 != 0)
						System.out.print("..#.");
					else
						System.out.print("..*.");
				else if(i == 1 || i == 3)
					if(j % 3 != 0)
						System.out.print(".#.#");
					else
						System.out.print(".*.*");
				else
					if(j % 3 == 0 || (j != 1 && j % 3 == 1))
						System.out.print("*."+ alpha[j-1] +".");
					else
						System.out.print("#."+ alpha[j-1] +".");
			}
			if(i != 2)
				System.out.println(".");
			else
				if(index % 3 == 0)
					System.out.println("*");
				else
					System.out.println("#");
		}
	}
}