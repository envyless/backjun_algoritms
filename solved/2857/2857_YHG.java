import java.io.*;

public class Problem_2857 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String tmp;
		char[] check = {'F','B','I'};
		int index;
		boolean find = false;
		
		for(int i = 1 ; i < 6 ; i++) {
			tmp = br.readLine();
			index = 0;
			
			for(int j = 0 ; j < tmp.length() ; j++) {
				if(tmp.charAt(j) != check[index]) {
					index = 0;
					continue;
				}
				else {
					if(index == 2) {
						System.out.print(i + " ");
						find = true;
						break;
					}
					else
						index++;
				}
			}
		}		
		if(!find)
			System.out.println("HE GOT AWAY!");
	}
}