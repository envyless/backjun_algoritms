import java.io.*;

public class Problem_1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		int len = insert.length();
		
		char tmp;
		String save = "";
		int value = 0;
		int tmpS = 0;
		boolean plus = true;
		for(int i = 0 ; i < len ; i++) {
			tmp = insert.charAt(i);
			
			if(tmp >= '0' && tmp <= '9')
				save += tmp;
			else {
				if(plus) {
					value += Integer.parseInt(save);
					save = "";
				}
				else {
					tmpS += Integer.parseInt(save);
					save = "";
				}
				if(tmp == '-')
					plus = false;
			}
		}
		
		if(plus)
			value += Integer.parseInt(save);
		else {
			tmpS += Integer.parseInt(save);
			value -= tmpS;
		}
		System.out.println(value);
	}
}