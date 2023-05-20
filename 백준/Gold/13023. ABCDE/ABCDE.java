import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	//사람의 수, 친구 관계 수
	static int N, M;
	static ArrayList<Integer>[] friendRelationship;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		//사람의 수, 친구 관계 수 입력
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		
		friendRelationship = new ArrayList[N];
		
		//관계 리스트
		for (int i = 0; i < N; i++) {
			friendRelationship[i] = new ArrayList<>();
		}
				
		int result =0;
		
		//관계 입력
		for (int i = 0; i < M; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int friend1 = Integer.parseInt(stringTokenizer.nextToken());
			int friend2 = Integer.parseInt(stringTokenizer.nextToken());
			
			friendRelationship[friend1].add(friend2);
			friendRelationship[friend2].add(friend1);
		}
//		
//		for (int i = 0; i < N; i++) {
//			System.out.println(friendRelationship[i].toString());
//		}
		
		for (int i = 0; i < N; i++) {
			boolean[] visit = new boolean[N];
			visit[i] = true;
			if (dfs(0, visit, i)) {
				result = 1;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	private static boolean dfs(int count, boolean[] visit, int index) {
		
		if (count == 4) {
			return true;
		}
		
		for (int i = 0; i < friendRelationship[index].size(); i++) {
			if (visit[friendRelationship[index].get(i)]) continue;
			
			visit[friendRelationship[index].get(i)] = true;
			if (dfs(count+1, visit, friendRelationship[index].get(i))) {
				return true;
			}
			visit[friendRelationship[index].get(i)] = false;
		}
		
		return false;
	}

}
