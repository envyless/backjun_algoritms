import java.io.*;

public class Problem_2810 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		String insert = br.readLine();
		
		char[] seat = new char[insert.length() * 2 + 1];
		boolean[] cup = new boolean[insert.length() * 2 + 1];
		seat[0] = '*';
		
		int index = 1;
		for(int i = 0 ; i < insert.length() ; i++) {
			if(insert.charAt(i) == 'S')
				seat[index++] = 'S';
			else if(insert.charAt(i) == 'L') {
				seat[index++] = 'L';
				seat[index++] = 'L';
				i++;
			}
			seat[index++] = '*';
		}
		
		int people = 0;
		for(int i = 0 ; i < seat.length ; i++) {
			if(seat[i] == '*')
				continue;
			
			if(seat[i] == 'S') {
				if(seat[i-1] == '*' && !cup[i-1]) {
					cup[i-1] = true;
					people++;
				}
				else if(seat[i+1] == '*' && !cup[i+1]) {
					cup[i+1] = true;
					people++;
				}
			}
			
			if(seat[i] == 'L') {
				if(seat[i-1] == '*' && !cup[i-1]) {
					cup[i-1] = true;
					people++;
				}
				i++;
				if(seat[i+1] == '*' && !cup[i+1]) {
					cup[i+1] = true;
					people++;
				}
			}
		}
		System.out.println(people);
	}
}