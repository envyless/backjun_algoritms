import java.io.*;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_10814 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		PriorityQueue<people> pq = new PriorityQueue<people>(new AGE());
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int age = Integer.parseInt(st.nextToken()); // 나이
			String name = st.nextToken(); // 이름
			pq.add(new people(i,age,name));
		}
		
		while(!pq.isEmpty()) {
			people people = pq.poll();
			int age = people.age;
			String name = people.name;
			
			System.out.println(age + " " + name);
		}
	}

}

class people{
	int count;
	int age;
	String name;
	
	public people(int count, int age, String name) {
		this.count = count;
		this.age = age;
		this.name = name;
	}
}

class AGE implements Comparator<people>{
	
	public int compare(people v1, people v2) {
		if(v1.age == v2.age)
			return v1.count < v2.count ? -1 : 1;
		else
			return v1.age < v2.age ? -1 : 1;
    }
}