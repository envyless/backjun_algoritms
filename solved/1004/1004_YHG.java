import java.io.*;
import java.util.StringTokenizer;

public class Problem_1004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		int pointX,pointY,pointR, disA,disB,disR;
		for(int TT = 0 ; TT < T ; TT++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				pointX = Integer.parseInt(st.nextToken());
				pointY = Integer.parseInt(st.nextToken());
				pointR = Integer.parseInt(st.nextToken());
				
				disA = (pointX - startX) * (pointX - startX) + (pointY - startY) * (pointY - startY);
				disB = (pointX - endX) * (pointX - endX) + (pointY - endY) * (pointY - endY);
				disR = pointR * pointR;
				if((disR < disA && disR > disB) || (disR > disA && disR < disB))
					count++;
			}
			
			System.out.println(count);
		}
	}
}