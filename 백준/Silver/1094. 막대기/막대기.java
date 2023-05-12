import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
			//만들어야 하는 막대 길이
			int resultLength = Integer.parseInt(bufferedReader.readLine());
			
			//가지고 있는 막대들의 리스트(우선순위 큐로 정렬한상태로 진행)
			PriorityQueue<Integer> stickList = new PriorityQueue<>();
			stickList.add(64);	//처음 길이 입력
			
			//가지고 있는 막대 길이가 resultLength와 같아 질때까지 반복
			while(totalStick(stickList) != resultLength) {
				//막대중 가작 작은 길이를 꺼낸다.
				int minNum = stickList.poll();
				//막대를 이등분 한 것 중 하나를 막대 리스트에 넣고
				stickList.offer(minNum / 2);
				//이등분 한 것 중 하나를 포함한 막대길이 총합이 resultLength보다 작으면 나머지 하나도 포함시킨다.
				if(totalStick(stickList) < resultLength) stickList.offer(minNum / 2);
			}
			
			StringBuilder stringBuilder = new StringBuilder().append(stickList.size());
			System.out.println(stringBuilder);
		
	}

	//가지고 있는 막대들의 총합 구하기
	private static int totalStick(PriorityQueue<Integer> stickList) {
		int result = 0;
		Object[] array = stickList.toArray();
		
		for (int i = 0; i < stickList.size(); i++) {
			result += (int) array[i];
		}
		return result;
	}

}
