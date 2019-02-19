import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1713 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 틀의 수를 입력 받음
		int M = Integer.parseInt(br.readLine()); // 추천 횟수를 입력 받음
		int[][] insert = new int[N][3]; 
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		int tmp;
		int start = 0;
		for(int i = 0 ; i < M ; i++) {
			tmp = Integer.parseInt(st.nextToken()); // 현재 순서에서 추천 받은 사람의 번호가 tmp에 들어감
			
			if(start < N) { // N개의 빈 틀이 있으므로 N개의 입력을 받을 때 까지 틀을 채움
				boolean startIn = true;
				for(int j = 0 ; j < start ; j++) {
					if(tmp == insert[j][0]) {
						insert[j][2]++;
						startIn = false;
					}
				}
				if(!startIn)
					continue;
				
				insert[start][0] = tmp; // 0번은 추천된 번호
				insert[start][1] = i; // 1번은 추천된 시간
				insert[start][2] = 1; // 2번은 추천 횟수
				start++;
				continue;
			}
			
			// 여기 아래가 진행된다는 것은, 틀이 꽉 찼다는 소리.
			int old = 1000;
			int reco = 1000; // 추천의 최대 횟수가 1000이므로 최댓값인 1000을 저장
			int index = 0;
			boolean yes = false;
			
			//틀이 꽉 찼으면, N개의 틀을 확인해서 이미 있는 사람인지 확인
			for(int j = 0 ; j < N ; j++) {
				
				if(tmp == insert[j][0]) { // 0번이 번호이므로, 추천된 사람이 있으면 추천 횟수를 증가
					insert[j][2]++;
					yes = true; // 있으면 다음 사람을 확인하도록 하기 위한 변수
					break;
				}
				
				if(reco > insert[j][2]) // 위에 추천된 사람이 아닌 경우, reco 값에는 추천된 값이 가장 작은 수가 들어감
					reco = insert[j][2];
			}
			
			if(yes) // 틀에 이미 있는 사람이 추천 되었고, 추천 횟수를 증가시켰으므로 다음 추천을 받는다.
				continue;
			
			// 이곳 아래가 실행되면 틀에 없는 사람이 추천되었음.
			for(int j = 0 ; j < N ; j++) {
				if(reco == insert[j][2]) // 위의 if문에 의하여 reco에는 추천의 최솟값이 들어감. 최솟값을 가진 사람이 많을 수 있으므로 같을 경우에만 수행
					if(old > insert[j][1]) { // 최소가 같으면, 가장 오래된 사진을 선택해야 함. old가 클수록 최신. 따라서, old가 작을 때만 갱신함
						old = insert[j][1]; // 현재 old가 가장 낮은 수 이므로 old에 현재 값을 갱신
						index = j; // 현재 j이 index 값을 저장.
					}
			}
			
			// index에는 최소의 추천 값인 reco를 가지면서, 그 중 old가 가장 낮은 index의 값을 새로운 값으로 갱신시킨다.
			insert[index][0] = tmp; // 현재 추천 받은 사람을 해당 index에 저장
			insert[index][1] = i; // 새로 저장 하는 것 이므로, 추천 받은 순서를 저장
			insert[index][2] = 1; // 새로 저장 하는 것 이므로 추천 횟수를 1로 다시 갱신
		}
		
		for(int i = 0 ; i < N ; i++)
			result[i] = insert[i][0];
		Arrays.sort(result);
		for(int i = 0 ; i < N ; i++)
			System.out.print(result[i] + " ");
	}
}