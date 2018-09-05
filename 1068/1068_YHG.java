import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1068 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // 노드의 수
		int[] tree = new int[N]; // 부모 노드의 번호가 저장
		for(int i = 0 ; i < N ; i++)
			tree[i] = scn.nextInt();
		
		int del = scn.nextInt(); // 지울 노드의 번호
		tree[del] = -2;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(del);
		
		while(!q.isEmpty()) {
			int delIndex = q.poll();
			
			for(int i = 0 ; i < N ; i++) {
				if(tree[i] == delIndex) {
					q.add(i);
					tree[i] = -2;
				}
			}
		}
		
		int[] child = new int[N]; // 자식 노드의 개수가 저장
		for(int i = 0 ; i < N ; i++) {
			if(tree[i] == -1 || tree[i] == -2)
				continue;
			child[tree[i]]++;
		}
		
		int count = 0;
		for(int i = 0 ; i < N ; i++)
			if(child[i] == 0 && tree[i] != -2)
				count++;
		
		System.out.println(count);
	}
}