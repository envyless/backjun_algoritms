import java.util.Scanner;

public class Problem_10798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String[] line = new String[5];
		int max = 0;
		for(int i = 0 ; i < 5 ; i++) {
			line[i] = scn.nextLine();
			if(max < line[i].length())
				max = line[i].length();
		}
		
		char[][] alpha = new char[5][16];
		for(int i = 0 ; i < 5 ; i++)
			for(int j = 0 ; j < line[i].length() ; j++)
				alpha[i][j] = line[i].charAt(j);
		
		for(int i = 0 ; i < max ; i++)
			for(int j = 0 ; j < 5 ; j++) {
				if(alpha[j][i] == '\0')
					continue;
				System.out.print(alpha[j][i]);
			}
	}
}