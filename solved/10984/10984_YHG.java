import java.io.*;
import java.util.StringTokenizer;

public class Problem_10984 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine());
			int gr = 0;
			int grS = 0;
			float sco = 0;
			float gpa = 0;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				gr = Integer.parseInt(st.nextToken());
				sco = Float.parseFloat(st.nextToken());
				gpa += gr*sco;
				grS += gr;
			}
			gpa /= grS;
			
			System.out.println(grS + " " + Math.round(gpa*10)/10.0);
		}
	}
}