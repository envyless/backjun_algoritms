import java.io.*;

public class Problem_9996 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		String in = br.readLine();
		String f = "";
		String b = "";
		boolean check = false;
		for(int i = 0 ; i < in.length() ; i++) {
			if(in.charAt(i) == '*') {
				check = true;
				continue;
			}
			if(!check)
				f += in.charAt(i);
			else
				b += in.charAt(i);
		}
		
		String tmp;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			check = false;
			
			if(tmp.length() < f.length() + b.length()) {
				System.out.println("NE");
				continue;
			}
			
			for(int j = 0 ; j < f.length() ; j++) {
				if(f.charAt(j) != tmp.charAt(j)) {
					check = true;
					break;
				}
			}
			if(check) {
				System.out.println("NE");
				continue;
			}
			
			int index = tmp.length()-1;
			for(int j = b.length()-1 ; j >= 0 ; j--) {
				if(b.charAt(j) != tmp.charAt(index--)) {
					check = true;
					break;
				}
			}
			if(check)
				System.out.println("NE");
			else
				System.out.println("DA");
		}
	}
}