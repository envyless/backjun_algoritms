import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pqM = new PriorityQueue<Integer>(new ASC_1461());
		PriorityQueue<Integer> pqP = new PriorityQueue<Integer>(new DESC_1461());
		
		int tmp;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(tmp < 0)
				pqM.add(tmp);
			else if(tmp > 0)
				pqP.add(tmp); // 0은 사용하지 않아도 됨.
		}
		
		int move = 0;
		int max = 0;
		if(!pqM.isEmpty() && !pqP.isEmpty())
			max = Math.max(Math.abs(pqM.peek()),pqP.peek());
		else if(pqM.isEmpty() && !pqP.isEmpty())
			max = pqP.peek();
		else if(!pqM.isEmpty() && pqP.isEmpty())
			max = Math.abs(pqM.peek());
		int count = 0;
		tmp = 0;
		while(!pqM.isEmpty()) {
			count++;
			tmp = pqM.poll();
			if(count == 1)
				move += (Math.abs(tmp)*2);
			if(count == M)
				count = 0;
		}
		
		tmp = 0;
		count = 0;
		while(!pqP.isEmpty()) {
			count++;
			tmp = pqP.poll();
			if(count == 1)
				move += (tmp*2);
			if(count == M)
				count = 0;
		}
		
		move -= max;
		System.out.println(move);
	}
}
class ASC_1461 implements Comparator<Integer>{
	public int compare(Integer v1, Integer v2) {
		return v1 - v2 < 0 ? -1 : 1; // 오름차순
    }
}

class DESC_1461 implements Comparator<Integer>{
	public int compare(Integer v1, Integer v2) {
		return v1 - v2 > 0 ? -1 : 1; // 내림차순
    }
}