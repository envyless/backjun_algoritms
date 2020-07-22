import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TC = 0 ; TC < T ; TC++) {
			int data = scn.nextInt();
			int index = scn.nextInt();
			
			Queue<printer> q = new LinkedList<printer>();
			int[] check = new int[data];
			
			for(int i = 0 ; i < data ; i++) {
				int tmp = scn.nextInt();
				boolean printer = false;
				if(i == index)
					printer = true;
				
				q.add(new printer(tmp, printer));
				check[i] = tmp;
				
			}
			Arrays.sort(check);
			
			int checkIndex = check.length - 1;
			int count = 0;
			
			while(!q.isEmpty()) {
				printer printer = q.poll();
				int nowIndex = printer.count;
				boolean indexPrint = printer.print;
				
				if(check[checkIndex] <= nowIndex) {
					count++;
					checkIndex--;
					if(indexPrint) {
						System.out.println(count);
						break;
					}
				}
				else 
					q.add(new printer(nowIndex, indexPrint));
			}
			
		}
	}
}

class printer{
	int count;
	boolean print;
	
	public printer(int count, boolean print) {
		this.count = count;
		this.print = print;
	}
}