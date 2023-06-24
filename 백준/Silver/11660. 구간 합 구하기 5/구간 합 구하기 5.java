import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int boxSize = Integer.parseInt(stringTokenizer.nextToken());
		int mCount = Integer.parseInt(stringTokenizer.nextToken());
		
		int[][] sumArr =new int[boxSize][boxSize];
		
		for (int i = 0; i < boxSize; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			sumArr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			for (int j = 1; j < boxSize; j++) {
				sumArr[i][j] = sumArr[i][j-1] + Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		int[] section =new int[4];
		StringBuilder stringBuilder =new StringBuilder();
		for (int i = 0; i < mCount; i++) {
			int sum =0;
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 4; j++) {
				section[j] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			for (int j = section[0]-1; j < section[2]; j++) {
				int x=0;
				if(section[1]-2 < 0) x = 0;
				else x = sumArr[j][section[1]-2];
				sum += sumArr[j][section[3]-1] - x;
			}
			
			stringBuilder.append(sum).append("\n");
		}
		System.out.println(stringBuilder);
	}

}
