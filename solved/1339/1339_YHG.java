import java.io.*;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_1339 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		
		String[] insert = new String[N];
		int[] alpha = new int[26];
		int[] value = new int[26];
		PriorityQueue<point_1339> pq = new PriorityQueue<point_1339>(new ASC_1339());
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = br.readLine();
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = insert[i];
			int mul = 1;
			for(int j = tmp.length()-1 ; j >=0 ; j--, mul *= 10)
				alpha[tmp.charAt(j) - 'A'] += mul;
		}
		
		
		for(int i = 0 ; i < 26 ; i++)
			if(alpha[i] != 0)
				pq.add(new point_1339(i,alpha[i]));
		
		int nowValue = 9;
		while(!pq.isEmpty()) {
			point_1339 now = pq.poll();
			value[now.index] = nowValue;
			nowValue--;
		}
		
		int sum = 0;
		for(int i = 0 ; i < 26 ; i++) {
			if(alpha[i] == 0)
				continue;
			sum += (alpha[i] * value[i]);
		}
		System.out.println(sum);
	}
}
class point_1339{
	int index;
	int value;
	
	public point_1339(int x, int y) {
		this.index = x;
		this.value = y;
	}
}

class ASC_1339 implements Comparator<point_1339>{
	
	public int compare(point_1339 v1, point_1339 v2) {
		return v1.value - v2.value > 0 ? -1 : 1;
    }
}