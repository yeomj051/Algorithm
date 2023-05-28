import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {


		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		StringTokenizer stringTokenizer = new StringTokenizer(input);
		StringBuilder stringBuilder = new StringBuilder("<");
		
		int count = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());
		
		ArrayList<Integer> numList = new ArrayList<>();
		int index = K-1;
		
		for (int i = 1; i <= count; i++) {
			numList.add(i);
		}
		
		while (numList.size() > 0) {
			stringBuilder.append(numList.get(index)).append(",").append(" ");

			numList.remove(index);
			
			index += K-1;
			
			while(numList.size() <= index && numList.size()>0) {
//				System.out.println(numList.size() + " " + index);
				index -= numList.size();
			}
//			if(numList.size() < index) {
				
//			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.append(">");
		System.out.println(stringBuilder);


	}

}
