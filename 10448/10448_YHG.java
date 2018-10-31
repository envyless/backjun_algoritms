import java.io.*;

public class Problem_10448 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		int[] value = new int[50];
		int index = 0;
		for(int i = 1 ; i < 50 ; i++) {
			int tmp = i * (i+1) / 2;
			if(tmp >= 1000)
				continue;
			value[i] = tmp;
		}
		
		for(int TT  = 0 ; TT < T ; TT++) {
			int N = Integer.parseInt(br.readLine()); // 구할 값 
			boolean check = false;
			for(int i = 49 ; i >= 0 ; i--) {
				if(value[i] >= N || value[i] == 0)
					continue;
				int sum = value[i];
				
				for(int j = i ; j >= 0 ; j--) {
					if(value[j] >= N || value[j] == 0)
						continue;
					sum = value[i] + value[j];
					for(int k = j ; k >= 0 ; k--) {
						if(value[k] >= N || value[k] == 0)
							continue;
						int test = sum + value[k];
						if(test == N) {
							check = true;
							break;
						}
					}
					if(check)
						break;
				}
				if(check)
					break;
			}
			if(check)
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.close();
	}
}