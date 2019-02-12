import java.io.*;

public class Problem_2966 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		String insert = br.readLine();
		char tmp;
		int Adrian = 0;
		int Bruno = 0;
		int Goran = 0;
		
		char[] Ad = { 'A', 'B', 'C' };
		char[] Br = { 'B', 'A', 'B', 'C' };
		char[] Go = { 'C', 'C', 'A', 'A', 'B', 'B' };
		int indexA = 0;
		int indexB = 0;
		int indexG = 0;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = insert.charAt(i);
			
			if(tmp == Ad[indexA++])
				Adrian++;
			if(tmp == Br[indexB++])
				Bruno++;
			if(tmp == Go[indexG++])
				Goran++;
			
			if(indexA == Ad.length)
				indexA = 0;
			if(indexB == Br.length)
				indexB = 0;
			if(indexG == Go.length)
				indexG = 0;
		}
		
		int max = Math.max(Adrian, Math.max(Bruno, Goran));
		System.out.println(max);
		if(max == Adrian)
			System.out.println("Adrian");
		if(max == Bruno)
			System.out.println("Bruno");
		if(max == Goran)
			System.out.println("Goran");
	}
}