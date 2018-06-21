import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;


public class Problem_1753 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int INF = 99999999;
		
		Scanner scn = new Scanner(System.in);

		int V = scn.nextInt(); // ������ ����
		int E = scn.nextInt(); // ������ ����
		int start = scn.nextInt(); // ���� ��
		
		int[] weight = new int[V+1];
		boolean[] visit = new boolean[V+1];
		
		PriorityQueue<pointWeight> q = new PriorityQueue<pointWeight>(new Com());
		ArrayList<insertData>[] edge = new ArrayList[V+1];
		
		for(int i = 0 ; i < V+1 ; i++) {
			weight[i] = INF;
			visit[i] = false;
			edge[i] = new ArrayList<insertData>();
		}
		
		// ��� ���� �Է� ����.
		for(int i = 0 ; i < E ; i++) {
			int started = scn.nextInt();
			int end = scn.nextInt();
			int value = scn.nextInt();

			// started���� ���۵Ǵ� ��� ������ edge[started]�� �����
			edge[started].add(new insertData(end, value));
		}
		
		weight[start] = 0;
		q.add(new pointWeight(start,weight[start]));
		
		while(!q.isEmpty()) {
			pointWeight pw = (pointWeight)q.remove();
			
			int startPoint = pw.point;
			int plusWeight = pw.weight;
			
			if(!visit[startPoint]) {
				visit[startPoint] = true;
				
				if(edge[startPoint].size() == 0) {
					continue;
				}else {
					// startPoint���� �̵��� �� �ִ� ������ Ȯ��
					while(!edge[startPoint].isEmpty()) {
						insertData data = edge[startPoint].remove(0);
						int insertEnd = data.end;
						int insertValue = data.value;
						if(weight[insertEnd] > insertValue + plusWeight)
							weight[insertEnd] = insertValue + plusWeight;
						
						q.add(new pointWeight(insertEnd, weight[insertEnd]));
					}
				}
			}
		}
		
		for(int i = 1 ; i < V+1 ; i++) {
			if(weight[i] == INF)
				System.out.println("INF");
			else
				System.out.println(weight[i]);
		}
	}
}

class insertData {
	int end;
	int value;
	public insertData(int y, int z) {
		end = y;
		value = z;
	}
}

class pointWeight{
	int point;
	int weight;
	public pointWeight(int x,int y) {
		point = x;
		weight = y;
	}
}

class Com implements Comparator<pointWeight>{
	
	public int compare(pointWeight d1, pointWeight d2) {
        return d1.weight < d2.weight ? -1 : 1;
    }
}