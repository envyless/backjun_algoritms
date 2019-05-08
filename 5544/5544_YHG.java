import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_5544 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] score = new int[N][N];
		int[] total = new int[N];
		int[] value = new int[N];
		int game = N*(N-1)/2;
		
		PriorityQueue<score_5544> pq = new PriorityQueue<score_5544>(new ASC_5544());
		
		int t1,t2,s1,s2;
		for(int i = 0 ; i < game ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			t1 = Integer.parseInt(st.nextToken())-1;
			t2 = Integer.parseInt(st.nextToken())-1;
			s1 = Integer.parseInt(st.nextToken());
			s2 = Integer.parseInt(st.nextToken());
			
			if(s1 > s2)  // t1 ¿Ã±Ë
				score[t1][t2] = 3;
			else if(s1 < s2) // t2 ¿Ã±Ë
				score[t2][t1] = 3;
			else // π´Ω¬∫Œ
				score[t1][t2] = score[t2][t1] = 1;
		}
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				total[i] += score[i][j];
		
		for(int i = 0 ; i < N ; i++)
			pq.add(new score_5544(i,total[i]));
		
		score_5544 now = pq.poll();
		value[now.x] = 1;
		int vl = 1;
		int sc = now.y;
		int count = 0;
		while(!pq.isEmpty()) {
			now = pq.poll();
			if(now.y != sc) {
				if(count == 0)
					count = 1;
				value[now.x] = vl + count;
				vl += count;
				count = 0;
				sc = now.y;
			}
			if(now.y == sc) {
				value[now.x] = vl;
				count++;
			}
		}
		
		for(int i = 0 ; i < N ; i++)
			System.out.println(value[i]);
	}
}

class score_5544{
	int x;
	int y;
	
	public score_5544(int team, int score) {
		this.x = team;
		this.y = score;
	}
}

class ASC_5544 implements Comparator<score_5544>{
	
	public int compare(score_5544 v1, score_5544 v2) {
		return v1.y - v2.y > 0 ? -1 : 1;
    }
}