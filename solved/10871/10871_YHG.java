import java.io.*;
import java.util.StringTokenizer;

public class Problem_10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		st = new StringTokenizer(br.readLine()," ");
		
		int count = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < count ; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(find > value)
				bw.write(value + " ");
		}
		bw.close();
	}
}