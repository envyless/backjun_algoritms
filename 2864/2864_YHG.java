import java.io.*;
import java.util.StringTokenizer;

public class Problem_2864 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String f = st.nextToken();
		String s = st.nextToken();
		
		String f1 = "", f2 = "", s1 = "", s2 = "";
		char tmp;
	
		for(int i = 0 ; i < f.length() ; i++) {
			tmp = f.charAt(i);
			if(tmp == '5' || tmp == '6') {
				f1 += '5';
				f2 += '6';
			}
			else {
				f1 += tmp;
				f2 += tmp;
			}
		}
		
		for(int i = 0 ; i < s.length() ; i++) {
			tmp = s.charAt(i);
			if(tmp == '5' || tmp == '6') {
				s1 += '5';
				s2 += '6';
			}
			else {
				s1 += tmp;
				s2 += tmp;
			}
		}
		
		System.out.print(Integer.parseInt(f1) + Integer.parseInt(s1));
		System.out.print(" " + (Integer.parseInt(f2) + Integer.parseInt(s2)));
	}
}