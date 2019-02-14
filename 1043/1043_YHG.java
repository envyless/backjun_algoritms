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
			if(index == 0) // ����� ���ٴ� ��.
				continue;
			
			for(int j = 0 ; j < index ; j++) {
				int save = Integer.parseInt(st.nextToken());
				party[i].add(save); // i ��° ��Ƽ�� ��� �ִ� ����� ���
				people[save].add(i); // save �� ����� ���� �ϴ� ��Ƽ�� ���
			}
		}
		
		int number1, number2;
		while(!q.isEmpty()) {
			number1 = q.poll(); // ������ �ƴ� ����� ��ȣ
			while(!people[number1].isEmpty()) {
				number2 = people[number1].poll(); // ������ �ƴ� ����� �����ϴ� ��Ƽ�� ��ȣ
				
				if(parCheck[number2])
					continue;
				
				parCheck[number2] = true;
				
				while(!party[number2].isEmpty())
					q.add(party[number2].poll()); // ������ �˾ƾ� �ϴ� ��Ƽ�� ������ ����� ��ȣ
			}
		}
		
		int count = 0;
		for(int i = 1 ; i < M+1 ; i++)
			if(!parCheck[i]) 
				count++;
		System.out.println(count);
	}
}