import java.util.Scanner;

public class Problem_2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// ���� �ö� ����
		int A = scn.nextInt();
		// �㿡 ������ ����
		int B = scn.nextInt();
		// ���� ������ ����
		int V = scn.nextInt();
		// �ϼ�
		int count = (V-A) / (A-B);
		int tmp = (V-A) % (A-B);
		
		if(tmp != 0)
			count++;
		count++;
		System.out.println(count);
	}

}
