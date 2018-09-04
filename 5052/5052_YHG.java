import java.io.*;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_5052 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine()); // 번호 개수
			PriorityQueue<String> pq = new PriorityQueue<String>(new ASC_5052());
			
			for(int i = 0 ; i < N ; i++)
				pq.add(br.readLine());
			
			String[] arr = new String[N];
			int index = 0;
			while(!pq.isEmpty())
				arr[index++] = pq.poll();
			
			boolean eq = false;
			for(int i = 0 ; i < N ; i++) {
				String value = arr[i];
				if(value.length() == 10)
					continue;
				eq = false;
				boolean end = false;
				
				for(int j = i+1 ; j < N ; j++) {
					String tmp = arr[j];
					
					for(int k = 0 ; k < value.length(); k++) {
						if(k == 0)
							if(value.charAt(k) != tmp.charAt(k)) {
								end = true;
								break;
							}
						if(k == value.length() - 1) {
							if(value.charAt(k) == tmp.charAt(k)) {
								bw.write("NO\n");
								eq = true;
								break;
							}
						}
						if(value.charAt(k) == tmp.charAt(k))
							continue;
						else
							break;
						
					}
					if(end)
						break;
					if(eq)
						break;
				}
				if(eq)
					break;
			}
			if(!eq)
				bw.write("YES\n");
		}
		bw.close();
	}

}
class ASC_5052 implements Comparator<String>{
	
	public int compare(String v1, String v2) {
		return v1.compareTo(v2) < 0 ? -1 : 1;
    }
}