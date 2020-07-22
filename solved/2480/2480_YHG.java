import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2480 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int fir = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());
		int thr = Integer.parseInt(st.nextToken());
		
		if(fir == sec && fir == thr)
			System.out.println(10000 + fir * 1000);
		else if(fir != sec && fir != thr && sec != thr)
			System.out.println(Math.max(fir, Math.max(sec, thr))*100);
		else {
			if(fir == sec || fir == thr)
				System.out.println(1000+fir*100);
			else
				System.out.println(1000+sec*100);
		}
	}
}