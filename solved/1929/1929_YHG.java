import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1929 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// N ~ M 사이의 소수 모두 출력하기. M <= 100만
		boolean[] odd = new boolean[N+1];
		
		for(int i = 2 ; i <= N ; i++)
			odd[i] = true;
		
		for(int i = 2 ; i * i <= N ; i++)
			if(odd[i])
				for(int j = i * i ; j <= N ; j += i)
					odd[j] = false;
		
		for(int i = M ; i <= N ; i++)
			if(odd[i])
				bw.write(i + "\n");
		bw.close();
	}
}