import java.io.*;
import java.util.StringTokenizer;

public class Problem_1120 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		int count = 100;
		
		for(int i = 0 ; i <= b.length() - a.length() ; i++) {
			int tmp = 0;
			
			for(int j = 0 ; j < a.length() ; j++) {
				if(a.charAt(j) != b.charAt(i+j)) 
					tmp++;
			}
			if(tmp < count)
				count = tmp;
		}
		System.out.println(count);
	}
}