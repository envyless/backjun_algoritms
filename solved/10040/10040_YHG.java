import java.io.*;
import java.util.StringTokenizer;

public class Problem_10040 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] pay = new int[N];
		int[] pop = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			pay[i] = Integer.parseInt(br.readLine());
		
		int tmp;
		for(int i = 0 ; i < M ; i++) {
			tmp = Integer.parseInt(br.readLine());
			for(int j = 0 ; j < N ; j++ )
				if(pay[j] <= tmp) {
					pop[j]++;
					break;
				}
		}
		
		int max = 0;
		int num = 0;
		for(int i = 0 ; i < N ; i++)
			if(pop[i] > max) {
				max = pop[i];
				num = i+1;
			}
		System.out.println(num);
	}
}