import java.io.*;

public class Problem_1193 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int start = 1;
		int top = 1;
		int bot = 1;
		int topP = 1;
		int botP = 1;
		boolean check = false;
		
		while(start < N) {
			
			if(top == 1 && !check) {
				bot++;
				topP = 1;
				botP = -1;
				start++;
				check = true;
				continue;
			}
			else if(bot == 1 && check) {
				top++;
				topP = -1;
				botP = 1;
				start++;
				check = false;
				continue;
			}
			top += topP;
			bot += botP;
			start++;
		}
		System.out.println(top + "/" + bot);
	}
}