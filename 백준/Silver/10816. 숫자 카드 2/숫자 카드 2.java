import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int sangCardCount = Integer.parseInt(bufferedReader.readLine());
		HashMap<Integer,Integer> cardMap = new HashMap<>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < sangCardCount; i++) {
			int number = Integer.parseInt(stringTokenizer.nextToken());
			if (cardMap.get(number) == null) {
				cardMap.put(number, 1);
			}else{
				cardMap.replace(number, cardMap.get(number)+1);
			}
		}
		
		int M = Integer.parseInt(bufferedReader.readLine());
		
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int Mnumber = Integer.parseInt(stringTokenizer.nextToken());
			if(cardMap.containsKey(Mnumber)) {
				stringBuilder.append(cardMap.get(Mnumber)).append(" ");
				
			}else {
				stringBuilder.append(0).append(" ");
			}
			
		}
		
		System.out.println(stringBuilder);
		
	}

}
