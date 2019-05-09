import java.io.*;
import java.util.StringTokenizer;

public class Problem_11568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= N ; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		int[] len = new int[N+1];
		for(int i = 1 ; i <= N ; i++)
			for(int j = 0 ; j < i ; j++)
				if(card[i] > card[j] && len[i] < len[j]+1)
					len[i] = len[j]+1;
		
		int max = 0;
		for(int i = 0 ; i <= N ; i++)
			if(max < len[i])
				max = len[i];
		System.out.println(max);
	}
}