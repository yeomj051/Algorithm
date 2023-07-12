import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int count = Integer.parseInt(bufferedReader.readLine());
		Position[] positions = new Position[count];
		
		for (int i = 0; i < count; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			positions[i] = new Position(Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()));
			
		}
		Arrays.sort(positions);
		
		for (Position position : positions) {
			System.out.println(position);
		}
		
	}
	static class Position implements Comparable<Position>{
		int x;
		int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Position o) {
			
			if(this.x - o.x != 0) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}

		@Override
		public String toString() {
			return  x + " " + y;
		}
		
		
		
	}

}
