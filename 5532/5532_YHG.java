import java.io.*;

public class Problem_5532 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int[] insert = new int[5];
		for(int i = 0 ; i < 5 ; i++)
			insert[i] = Integer.parseInt(br.readLine());
		
		while(insert[0] >= 0) {
			insert[0]--;
			insert[1] -= insert[3];
			insert[2] -= insert[4];
			if(insert[1] <= 0 && insert[2] <= 0)
				break;
		}
		System.out.println(insert[0]);
	}
}