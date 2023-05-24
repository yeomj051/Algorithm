import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int T = 0; T < test_case; T++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int west = Integer.parseInt(stringTokenizer.nextToken());
			int east = Integer.parseInt(stringTokenizer.nextToken());
			
			long count = 1;
//			boolean[] visited = new boolean[east];

	        for(int i=1; i<=west; i++) count = count*(east-i+1)/i;
			stringBuilder.append(count).append("\n");
			
		}

		System.out.println(stringBuilder);

	}
    
//	private static int bridge(int count, boolean[] visited, int start, int east, int west) {
//        if (west == 0) {
//        	count++;
//        	return count;
//        }
//        for (int i = start; i < east; i++) {
//            visited[i] = true;
//            count = bridge(count, visited, i + 1, east , west-1);
//            visited[i] = false;
//        }
//        return count;
//        
//	}

}
