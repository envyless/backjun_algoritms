import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem_10825 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 학생 수
		PriorityQueue<student_10825> pq = new PriorityQueue<student_10825>(new Sort_10825());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			pq.add(new student_10825(name, ko, en, math));
		}
		
		while(!pq.isEmpty()) {
			student_10825 student = pq.poll();
			String name = student.name;
			System.out.println(name);
		}
	}

}
class student_10825{
	String name;
	int ko;
	int en;
	int math;
	
	public student_10825(String name, int ko, int en, int math) {
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.math = math;
	}
}

class Sort_10825 implements Comparator<student_10825>{
	
	public int compare(student_10825 v1, student_10825 v2) {
		// 국어 내림차순 > 영어 오름차순 > 수학 내림차순 > 이름 오름차순.
		if(v1.ko != v2.ko)
			return v1.ko - v2.ko > 0 ? -1 : 1;
		else if(v1.en != v2.en)
			return v1.en - v2.en < 0 ? -1 : 1;
		else if(v1.math != v2.math)
			return v1.math - v2.math > 0 ? -1 : 1;
		else
			return v1.name.compareTo(v2.name) < 0 ? -1 : 1;
			
    }
}