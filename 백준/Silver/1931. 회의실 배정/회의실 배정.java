import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//총 회의 개수
		int roomCount = Integer.parseInt(bufferedReader.readLine());
		
		Meeting[] meetins = new Meeting[roomCount];
		
		for (int i = 0; i < roomCount; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			meetins[i] = new Meeting(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
		}
		
		List<Meeting> result = getSchedule(meetins);
		System.out.println(result.size());
		

	}
	
	static  class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		//종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end-o.end : this.start-o.start;
		}
		
	}
	
	private static List<Meeting> getSchedule(Meeting[] meetings) {
		List<Meeting> result = new ArrayList<Meeting>();
		
		Arrays.sort(meetings);
		result.add(meetings[0]);
		
		for (int i = 1; i < meetings.length; i++) {
			if (result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		return result;
		
	}

}
