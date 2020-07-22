import java.io.*;

public class Problem_1254 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		String tmp = insert;
		
		if(check(insert)) {
			System.out.println(insert.length());
			return;
		}
		
		
		for(int i = 0 ; i < insert.length() ; i++) {
			tmp = insert;
			for(int j = i ; j >= 0 ; j--) {
				tmp += insert.charAt(j);
				if(check(tmp)) {
					System.out.println(tmp.length());
					return;
				}
			}
		}
	}
	
	static public boolean check(String insert) {
		int len = insert.length();
		if(len%2 != 0) {
			int index = (len+1)/2;
			for(int i = 0 ; i < index ; i++)
				if(insert.charAt(i) != insert.charAt(len-i-1))
					return false;
		}
		else {
			int index = len/2;
			for(int i = 0 ; i <= index ; i++)
				if(insert.charAt(i) != insert.charAt(len-i-1))
					return false;
		}
		return true;
	}
}