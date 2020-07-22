import java.util.Scanner;

public class Problem_5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		String insert = scn.nextLine();
		int result = 0;
		
		for(int i = 0 ; i < insert.length() ; i++) {
			int tmp = insert.charAt(i) - 'A';
			int time = 3;
			int count = 0;
			int save = 4;
			boolean check = false;
			while(count <= tmp) {
				count++;
				if(count == save) {
					save += 3;
					if(time < 10)
						time++;
				}
				if(time == 8 && !check) {
					check = true;
					save++;
				}
			}
			result += time;
		}
		System.out.println(result);
	}
}