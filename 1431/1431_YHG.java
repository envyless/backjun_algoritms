import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_1431 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		String tmp;
		int sum, len;
		PriorityQueue<serial_1431> pq = new PriorityQueue<serial_1431>(new ASC_1431());
		
		for(int i = 0 ; i < N ; i++) {
			sum = 0;
			tmp = br.readLine();
			len = tmp.length();
			
			for(int j = 0 ; j < len ; j++)
				if(tmp.charAt(j) >= '0' && tmp.charAt(j) <= '9')
					sum += tmp.charAt(j) - '0';
			pq.add(new serial_1431(tmp, len, sum));
		}
		
		while(!pq.isEmpty()) {
			serial_1431 now = pq.poll();
			System.out.println(now.serial);
		}
	}
}

class serial_1431{
	String serial;
	int len;
	int sum;
	
	public serial_1431(String serial, int len, int sum) {
		this.serial = serial;
		this.len = len;
		this.sum = sum;
	}
}

class ASC_1431 implements Comparator<serial_1431>{
	
	public int compare(serial_1431 v1, serial_1431 v2) {
		if(v1.len == v2.len)
			if(v1.sum == v2.sum)
				return v1.serial.compareTo(v2.serial) < 0 ? -1 : 1;
			else
				return v1.sum - v2.sum < 0 ? -1 : 1;
		else
			return v1.len - v2.len < 0 ? -1 : 1;
    }
}