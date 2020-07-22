import java.io.*;
import java.util.StringTokenizer;

public class Problem_1517 {

	public static long swap = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기 N(1≤N≤500,000)
		int[] insert = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(st.nextToken()); // 0≤|insert[i]|≤1,000,000,000
		int[] tmp = new int[N];
		mergeSort(insert, tmp);
		System.out.println(swap);
	}
	
	public static void mergeSort(int[] insert, int[] tmp) {
		int len = insert.length;
        
        if (len == 1) 
        	return;
       
        int[] tmp1 = new int[len/2];
        int[] tmp2 = new int[len - len/2];
       
        for (int i = 0; i < len/2; i++)
        	tmp1[i] = insert[i];

        mergeSort(tmp1, tmp);
        
        for (int i = 0; i < len - len/2; i++) 
        	tmp2[i] = insert[i + len/2];
        
        mergeSort(tmp2, tmp);
       
        sort(tmp1, tmp2, insert);
	}
	
	public static void sort(int[] tmp1, int[] tmp2, int[] insert) {
		int index1 = 0;
        int index2 = 0;
        int realIndex = 0;
       
        while (index1 < tmp1.length) {
                if (index2 < tmp2.length) {
                        if (tmp1[index1] < tmp2[index2]) {
                        	// 그대로 내리는 경우
                        	insert[realIndex] = tmp1[index1];
                        	index1++;
                        } else {
                        	// 바뀌는 경우
                        	swap += tmp1.length - index1;
                        	insert[realIndex] = tmp2[index2];
                        	index2++;
                        }
                        realIndex++;
                } else {
                        while (index1 < tmp1.length) {
                        	insert[realIndex] = tmp1[index1];
                        	index1++;
                        	realIndex++;
                        }
                }
        }
        while (index2 < tmp2.length) {
        	insert[realIndex] = tmp2[index2];
        	index2++;
        	realIndex++;
        }
	}
}