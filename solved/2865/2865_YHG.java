import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int M = Integer.parseInt(st.nextToken()); // 장르 수
		int K = Integer.parseInt(st.nextToken()); // 본선 진출 수
		
		double[] score = new double[N];
		int index;
		double tmp;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++) {
				index = Integer.parseInt(st.nextToken())-1;
				tmp = Double.parseDouble(st.nextToken());
				if(score[index] < tmp)
					score[index] = tmp;
			}
		}
		Arrays.sort(score);
		
		double sum = 0.0;
		for(int i = score.length - 1 ; i >= N-K ; i--) 
			sum += score[i];
		System.out.println(String.format("%.1f", sum));

	}
}