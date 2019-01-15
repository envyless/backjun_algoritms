import java.io.*;
import java.util.StringTokenizer;

public class Problem_2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String N = st.nextToken();
		String M = st.nextToken();
		int f = 0, s = 0;
		int m = 1;
		for(int i = 0 ; i < 3 ; i++, m *= 10) {
			int tmp = ((N.charAt(i) - '0')* m);
			f += tmp;
			tmp = ((M.charAt(i) - '0')* m);
			s += tmp;
		}
		if(f > s)
			System.out.println(f);
		else
			System.out.println(s);
	}
}