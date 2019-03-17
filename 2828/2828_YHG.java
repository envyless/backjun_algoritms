import java.io.*;
import java.util.StringTokenizer;

public class Problem_2828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = M;
		int move = 0;
		
		for(int TT = 0 ; TT < T ; TT++) {
			int ap = Integer.parseInt(br.readLine());
			if(ap >= start && ap <= end) 
				continue;
			
			if(ap < start) {
				move += start - ap;
				end -= start - ap;
				start = ap;
			}
			else if(ap > end) {
				move += ap - end;
				start += ap - end;
				end = ap;
			}
		}
		System.out.println(move);
	}
}