import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

			//절댓값 비교, 절댓값이 같으면 기존 값으로 비교
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Integer.compare(Math.abs(o1),Math.abs(o2)) == 0) {
					return Integer.compare(o1,o2);
				}
				
				return Integer.compare(Math.abs(o1),Math.abs(o2));
			}
			
		});
		
		int orderSize = Integer.parseInt(bufferedReader.readLine());
		
		for (int i = 0; i < orderSize; i++) {
			int nownumber = Integer.parseInt(bufferedReader.readLine());
			if (nownumber == 0) {
				if(priorityQueue.peek()==null) {
					stringBuilder.append(0).append("\n");
				}else {
					stringBuilder.append(priorityQueue.poll()).append("\n");
				}
				continue;
			}
			priorityQueue.offer(nownumber);
		}
		
		System.out.println(stringBuilder);

	}

}
