import java.io.*;
import java.util.StringTokenizer;

public class Problem_1138 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int[] line = new int[N];
		
		int h;
		for(int i = 0 ; i < N ; i++) {
			h = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < N ; j++)
				if(h == 0 && line[j] == 0) {
					line[j] = i+1;
					break;
				}
				else if(line[j] == 0)
					h--;
		}
		
		for(int i = 0 ; i < N ; i++)
			System.out.print(line[i]+ " ");
	}
}