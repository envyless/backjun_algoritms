import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_6588 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		boolean[] nodd = new boolean[1000001];
		int max = 1000000;
		
		for(int i = 2 ; i * i <= max ; i++)
			if(!nodd[i])
				for(int j = i * i ; j <= max ; j += i)
					nodd[j] = true;
		nodd[0] = true;
		nodd[1] = true;
		
		boolean find = false;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			
			find = false;
			for(int i = 2 ; i <= N ; i++) {
				if(!nodd[i]) // 소수일 때
					if(!nodd[N-i]) {  // N - i 도 소수이면.
						bw.write(N + " = " + i + " + " + (N-i) + "\n");
						find = true;
						break;
					}
			}
			if(!find)
				bw.write("Goldbach's conjecture is wrong.\n");
		}
		bw.close();
	}
}