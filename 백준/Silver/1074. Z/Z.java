import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int count = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int x = Integer.parseInt(stringTokenizer.nextToken());
		int y = Integer.parseInt(stringTokenizer.nextToken());

		solution((int) Math.pow(2,N),x,y);
		System.out.println(count);
	}

	private static void solution(int size, int x, int y) {
		if(size == 1){
			return;
		}
		int halfSize = size/2;
		if(x < halfSize && y < halfSize){
			solution(halfSize,x,y);
		} else if (x < halfSize && y >= halfSize) {
			count += halfSize * halfSize;
			solution(halfSize,x,y-halfSize);
		} else if (x >= halfSize && y < halfSize) {
			count += (halfSize * halfSize) * 2;
			solution(halfSize,x-halfSize,y);
		} else if (x >= halfSize && y >= halfSize) {
			count += (halfSize * halfSize) * 3;
			solution(halfSize,x-halfSize,y-halfSize);
		}
	}

}
