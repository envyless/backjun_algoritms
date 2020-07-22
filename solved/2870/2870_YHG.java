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
						// ù ��° ���� �ƴ� ���. 0 ~ 9�� �� ����
						if(check) { // ù ��° ���� 0�� ���.
							if(cTmp != '0') {  // ù ��°�� 0�̳�, �� ����� 0�� �ƴϴ�. 
								save = "";
								save += cTmp; // �� ��° ���� ù ��°�� ���.
								check = false;
							}
							// ù ��°�� �� ��°�� ��� 0�̴�. �̴� 0 �״��. > �ƹ��͵� ���� �ʾƵ� ��
						}
						else // ù ��° �������� 0�� �ƴ� ��� � ���� ���͵� ��� ����.
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