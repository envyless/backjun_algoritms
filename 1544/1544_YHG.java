import java.io.*;
import java.util.HashSet;

public class Problem_1544 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		
		hs.add(br.readLine());
		
		String tmp;
		for(int i = 1 ; i < N ; i++) {
			tmp = br.readLine();
			int len = tmp.length();
			
			StringBuilder sb;
			
			boolean check = false;
			for(String insert : hs) {
				sb = new StringBuilder(insert);
				
				for(int j = 0 ; j < len ; j++) {
					
					if(tmp.equals(sb.toString())) {
						check = true;
						break;
					}
					else {
						sb = sb.append(sb.charAt(0));
						sb = sb.deleteCharAt(0);
					}
				}
				if(check)
					break;
			}
			if(!check)
				hs.add(tmp);
		}
		
		System.out.println(hs.size());
	}
}