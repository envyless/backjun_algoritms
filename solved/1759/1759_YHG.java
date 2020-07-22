import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1759 {

	static int N;
	static int M;
	static char[] insert;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		insert = new char[M];
		
		for(int i = 0 ; i < M ; i++)
			insert[i] = st.nextToken().charAt(0);
		Arrays.sort(insert);
		pwd(0,0,0,"");
	}
	
	public static void pwd(int index, int m, int j, String result) {
		if(m >= 1 && j >= 2 && result.length() == N) {
			System.out.println(result);
			return;
		}
		if(index >= M)
			return;
		
		char tmp = insert[index];
		if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u')
			pwd(index+1, m+1, j, result+tmp);
		else
			pwd(index+1, m, j+1, result+tmp);
		pwd(index+1, m, j, result);
	}
}