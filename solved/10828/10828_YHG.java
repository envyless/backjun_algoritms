import java.io.*;
import java.util.StringTokenizer;

public class Problem_10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[10000];
		int index = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String tmp = st.nextToken();
			
			if(tmp.equals("push"))
				stack[index++] = Integer.parseInt(st.nextToken());
			else if(tmp.equals("pop")) {
				if(index == 0)
					System.out.println(-1);
				else
					System.out.println(stack[--index]);
			}
			else if(tmp.equals("size"))
				System.out.println(+index);
			else if(tmp.equals("empty")) {
				if(index == 0)
					System.out.println(1);
				else
					System.out.println(0);
			}
			else { // tmp == top
				if(index == 0)
					System.out.println(-1);
				else
					System.out.println(stack[index-1]);
			}
		}
	}
}