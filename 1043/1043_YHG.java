import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1043 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer>[] people = new LinkedList[N+1];
		Queue<Integer>[] party = new LinkedList[M+1];
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] parCheck = new boolean[M+1];
		
		String tmp = br.readLine();
		if(tmp.length() == 1) {	
			System.out.println(M);
			return;
		}
		
		for(int i = 1 ; i <= N ; i++)
			people[i] = new LinkedList<Integer>();
		for(int i = 1 ; i <= M ; i++)
			party[i] = new LinkedList<Integer>();
		
		st = new StringTokenizer(tmp," ");
		int real = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < real ; i++) {
			int tru = Integer.parseInt(st.nextToken());
			q.add(tru);
		}
		
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int index = Integer.parseInt(st.nextToken());
			if(index == 0) // 사람이 없다는 것.
				continue;
			
			for(int j = 0 ; j < index ; j++) {
				int save = Integer.parseInt(st.nextToken());
				party[i].add(save); // i 번째 파티에 들어 있는 사람의 목록
				people[save].add(i); // save 번 사람이 참여 하는 파티의 목록
			}
		}
		
		int number1, number2;
		while(!q.isEmpty()) {
			number1 = q.poll(); // 진실을 아는 사람의 번호
			while(!people[number1].isEmpty()) {
				number2 = people[number1].poll(); // 진실을 아는 사람이 참여하는 파티의 번호
				
				if(parCheck[number2])
					continue;
				
				parCheck[number2] = true;
				
				while(!party[number2].isEmpty())
					q.add(party[number2].poll()); // 진실을 알아야 하는 파티에 참여한 사람의 번호
			}
		}
		
		int count = 0;
		for(int i = 1 ; i < M+1 ; i++)
			if(!parCheck[i]) 
				count++;
		System.out.println(count);
	}
}