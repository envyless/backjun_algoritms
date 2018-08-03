import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // 단어의 개수
		
		PriorityQueue<String>[] pq = new PriorityQueue[51]; // range : 0 ~ 50
		
		for(int i = 1 ; i < 51 ; i++)
			pq[i] = new PriorityQueue<String>(new A());
		
		for(int i = 0 ; i < N ; i++) {
			String insert = scn.next();
			pq[insert.length()].add(insert);
		}
		
		String tmp = "1";
		for(int i = 1 ; i < 51 ; i++)
			while(!pq[i].isEmpty()) {
				if(!tmp.equals(pq[i].peek())) {
					tmp = pq[i].poll();
					System.out.println(tmp);
				}
				else
					pq[i].poll();
			}
	}
}

class A implements Comparator<String>{
	
	public int compare(String v1, String v2) {
        return v1.compareTo(v2)< 0 ? -1 : 1;
    }
}