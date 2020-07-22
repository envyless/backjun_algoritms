import java.util.Scanner; // Scanner�� �Է� �ޱ� ���� ���

public class Problem_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n;
				
		n = scn.nextInt();
		
		int[] input = new int[n];
		
		for(int i = 0 ; i < n ; i++)
			input[i] = scn.nextInt();
		
		// 1�� �̻��� ���ӵ� ���� ���� ������ ����
		int[] result = new int[n];
		int count = 0;
		
		for(int i = 0 ; i < n ; i++) {
			if(input[i] < 0)
				count++;
		}
		
		if(count == n) {
			// �Էµ� ���� ��� �����̸�.
			output(input,n);
			
		} else {
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = i ; j < n ; j++) {
					if(input[j] >= 0) {
						result[i] += input[j];
					}
					else {
						// ������ ������ ���.
						
						// ù ���� ������ ���. �迭���� 0�� ���ִ�. �� ��� �ٷ� �Ѿ��.
						if(result[i] <= 0) break;
						
						// ���ݱ����� ���� �հ� ������ ���� ������ �� ������ ������ �ٷ� �ѱ��.
						if(input[j] + result[i] <= 0) break;
						
						int tmp = check(input,j,n);			
						
						if(tmp != -1)
							result[i] += tmp;
						
						break;
					}
				}
			}
			output(result,n);
		}

	}
	
	static int check(int[] input, int j, int n) {
		
		int mi = input[j];
		int sum = 0;
		
		for(int i = j+1; i < n ; i++) {
			if(input[i] >= 0)
				sum += input[i];
			else {
				// �ٽ� ������ ������ ���
				int tmp = check(input,i,n);
				
				if(tmp != -1)
					sum += tmp;
				
				break;
			}
		}
		
		if(mi + sum > 0)
			return mi + sum;
		else 
			return -1;
	}
	
	static void output(int[] result, int n) {
		
		int max = result[0];
		int tmp;
		
		for(int i = 1 ; i < n ; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(max);
	}

}