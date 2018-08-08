import java.util.Scanner;

public class Problem_1076 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String[] color = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		String[] insert = new String[3];
		for(int i = 0 ; i < 3 ; i++)
			insert[i] = scn.next();
		
		String answer = "";
		int check = 0;
		
		for(int i = 0 ; i < 3 ; i++)
			for(int j  = 0 ; j < color.length ; j++)
				if(insert[i].equals(color[j]))
					if(i == 2) {
						if(check != 2)
							for(int count = 0 ; count < j ; count++)
								answer += "0";
					}else 
						if(i == 0 && j == 0) check++;
						else {
							if(j == 0) check++;
							answer += j+"";
						}
		System.out.println(answer);
	}
}