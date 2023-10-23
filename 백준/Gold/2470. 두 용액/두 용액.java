import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int numSize = Integer.parseInt(bufferedReader.readLine());
		long[] arr = new long[numSize];
		long min = Long.MAX_VALUE;
		int left =0;
		int right = numSize-1;
		
		long[] result = new long[2];
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		for (int i = 0; i < numSize; i++) {
			arr[i] = Long.parseLong(stringTokenizer.nextToken());
		}
		
		Arrays.sort(arr);
		
		while (left < right) {
			long sum = arr[left]+arr[right];
			if (min > Math.abs(sum)) {
				if(arr[left]>arr[right]) {
					result[0] = arr[right];
					result[1] = arr[left];
					}else {
						result[0] = arr[left];
						result[1] = arr[right];
					}
				min = Math.abs(sum);
			}
			if(sum < 0) left++;
			else if(sum == 0) break;
			else right--;
		}
		
		System.out.println(result[0] + " " + result[1]);
		
		
		

	}

}
