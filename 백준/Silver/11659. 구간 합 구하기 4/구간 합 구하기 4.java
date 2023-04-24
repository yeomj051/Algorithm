import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int NCount = Integer.parseInt(stringTokenizer.nextToken());
		int [] NSumArr = new int[NCount];
		int MCount = Integer.parseInt(stringTokenizer.nextToken());
		
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		NSumArr[0] = Integer.parseInt(stringTokenizer.nextToken()); 
		for (int i = 1; i < NCount; i++) {
			NSumArr[i] = NSumArr[i-1] + Integer.parseInt(stringTokenizer.nextToken()); 
		}
	
		StringBuilder stringBuilder =new StringBuilder();
		for (int i = 0; i < MCount; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			
			if(start-2 < 0) start = 0;
			else start = NSumArr[start-2];
			stringBuilder.append(NSumArr[end-1]-start).append("\n");
			
		}
		
		System.out.println(stringBuilder);
		
		
	}

}
