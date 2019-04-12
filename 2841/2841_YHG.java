import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Problem_2841 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int count = 0;
		
		Stack<Integer>[] stk = new Stack[7];
		for(int i = 1 ; i < 7 ; i++)
			stk[i] = new Stack<Integer>();
		
		int li, pl, tmp;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			li = Integer.parseInt(st.nextToken());
			pl = Integer.parseInt(st.nextToken());
			
			if(stk[li].isEmpty()) {
				count++;
				stk[li].push(pl);
				continue;
			}
			
			tmp = stk[li].peek();
			if(tmp == pl)
				continue;
			else if(tmp < pl) {
				stk[li].push(pl);
				count++;
			}
			else if(tmp > pl)
				while(true) {
					if(stk[li].isEmpty()) {
						stk[li].push(pl);
						count++;
						break;
					}
					tmp = stk[li].peek();
					if(tmp > pl) {
						stk[li].pop();
						count++;
					}
					else if(tmp == pl)
						break;
					else if(tmp < pl) {
						stk[li].push(pl);
						count++;
					}
				}
		}	
		System.out.println(count);
	}
}