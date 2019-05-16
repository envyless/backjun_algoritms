import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1526 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		// 4 , 7
		int insert = Integer.parseInt(br.readLine());
		int value = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		if(insert >= 4) {
			q.add(4);
			value = 4;
		}
		if(insert >= 7) {
			q.add(7);
			value = 7;
		}
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			now *= 10;
			now += 4;
			
			if(now <= insert) {
				value = now;
				q.add(now);
			}
			now += 3;
			if(now <= insert) {
				value = now;
				q.add(now);
			}
		}
		System.out.println(value);
	}
}