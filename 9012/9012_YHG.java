import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		scn.nextLine();
		
		String[] line = new String[t];
		
		for(int i = 0 ; i < t ; i++)
			line[i] = scn.nextLine();
		
		for(int i = 0 ; i < t ; i++) {
			int len = line[i].length();
			
			if(len < 2)
				System.out.println("NO");
			else {
				
				if(line[i].charAt(0) != '(')
					System.out.println("NO");
				else {
					
					int count = 0;
					for(int j = 0 ; j < line[i].length() ; j++) {
						if(line[i].charAt(j) == '(')
							count++;
						else {
							if(count <= 0) {
								count = -1;
								break;
							}
							else 
								count--;
						}
					}
					
					if(count == 0)
						System.out.println("YES");
					else
						System.out.println("NO");
					
				}
					
			}
		}
		
		
		
	}

}
