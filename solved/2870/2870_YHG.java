import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_2870 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<String>(new ASC_2870());
		String tmp;
		char cTmp;
		String save;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0 ; j < tmp.length() ; j++) {
				cTmp = tmp.charAt(j);
				save = "";
				boolean check = false;
				while(cTmp >= '0' && cTmp <= '9') {
					if(save.length() == 0 && cTmp == '0') {
						save = "0";
						check = true;
					}
					else {
						// 첫 번째 값이 아닌 경우. 0 ~ 9가 다 가능
						if(check) { // 첫 번째 값이 0인 경우.
							if(cTmp != '0') {  // 첫 번째가 0이나, 두 번재는 0이 아니다. 
								save = "";
								save += cTmp; // 두 번째 값을 첫 번째로 사용.
								check = false;
							}
							// 첫 번째와 두 번째가 모두 0이다. 이는 0 그대로. > 아무것도 하지 않아도 됨
						}
						else // 첫 번째 값이지만 0이 아닌 경우 어떤 값이 들어와도 상관 없음.
							save += cTmp;
					}
					j++;
					if(j >= tmp.length())
						break;
					cTmp = tmp.charAt(j);
				}
				if(save.length() == 0)
					continue;
				pq.add(save);
			}
		}

		
		while(!pq.isEmpty()) {
			String now = pq.poll();
			System.out.println(now);
		}
	}
}
class ASC_2870 implements Comparator<String>{
	
	public int compare(String v1, String v2) {
		if(v1.length() == v2.length())
			return v1.compareTo(v2) < 0 ? -1 : 1;
		else
			return v1.length() - v2.length() < 0 ? -1 : 1;
    }
}