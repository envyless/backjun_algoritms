import java.io.*;
import java.util.StringTokenizer;

public class Problem_2879 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] insert = new int[N];
		int[] g = new int[N];
		boolean[] cor = new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			g[i] = Integer.parseInt(st.nextToken());
		
		
		int tmp = 0;
		boolean min = false;
		boolean plu = false;
		int count = 0;
		boolean check = false;
		while(true) {
			check = min = plu = false;
			for(int i = 0 ; i < N ; i++) {
				tmp = insert[i] - g[i];
				if(tmp == 0) {
					cor[i] = true;
					min = plu = false;
					continue;
				}
				else if(tmp > 0) { // ���غ��� Ŭ ���, ���� �Ѵ�.
					if(!(min && !plu)) { //!(����) > ���Ұ� �ƴ� ���.
						min = true;
						plu = false;
						count++;
					}
					insert[i]--;
				}
				else { // tmp < 0 . �������� ���� ���, ���ؾ� �Ѵ�.
					if(!(!min && plu)) {
						min = false;
						plu = true;
						count++;
					}
					insert[i]++;
				}
			}
			
			for(int i = 0 ; i < N ; i++)
				if(!cor[i]) {
					check = true;
					break;
				}
			
			if(!check)
				break;
		}
		System.out.println(count);
	}
}