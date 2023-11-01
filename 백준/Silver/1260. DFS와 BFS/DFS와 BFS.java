import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		int startVertex = Integer.parseInt(stringTokenizer.nextToken());

		List<ArrayList<Integer>> vertexList = new ArrayList<>(nodeCount + 1);
		boolean[] isVistedDfs = new boolean[nodeCount + 1];
		boolean[] isVistedBfs = new boolean[nodeCount + 1];

		for (int i = 0; i <= nodeCount; i++) {
			vertexList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < edgeCount; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int node1 = Integer.parseInt(stringTokenizer.nextToken());
			int node2 = Integer.parseInt(stringTokenizer.nextToken());

			vertexList.get(node1).add(node2);
			vertexList.get(node2).add(node1);

		}
		
		for (int i = 0; i < vertexList.size(); i++) {
			Collections.sort(vertexList.get(i));
		}

		StringBuilder stringBuilderDfs = new StringBuilder();
		StringBuilder stringBuilderBfs = new StringBuilder();
		dfs(vertexList, isVistedDfs, startVertex, stringBuilderDfs);

		bfs(vertexList, isVistedBfs, stringBuilderBfs, startVertex);

		System.out.println(stringBuilderDfs);
		System.out.println(stringBuilderBfs);

	}

	private static void dfs(List<ArrayList<Integer>> vertexList, boolean[] isVisted, int nowNode,
			StringBuilder stringBuilderDfs) {
		isVisted[nowNode] = true;
		stringBuilderDfs.append(nowNode).append(" ");

		for (int i = 0; i < vertexList.get(nowNode).size(); i++) {
			if (isVisted[vertexList.get(nowNode).get(i)] == false) {
				dfs(vertexList, isVisted, vertexList.get(nowNode).get(i), stringBuilderDfs);
			}

		}
	}

	private static void bfs(List<ArrayList<Integer>> vertexList, boolean[] isVisted, StringBuilder stringBuilderBfs,
			final int startVertex) {
		Queue<Integer> bfsQueue = new LinkedList<>();
		bfsQueue.offer(startVertex);
		isVisted[startVertex] = true;
		stringBuilderBfs.append(startVertex).append(" ");
//		System.out.println(bfsQueue.toString());

		while (!bfsQueue.isEmpty()) {
			int nowNode = bfsQueue.poll();

//			System.out.println(vertexList.get(nowNode).size());
			for (int i = 0; i < vertexList.get(nowNode).size(); i++) {
				if (isVisted[vertexList.get(nowNode).get(i)]) {
					continue;
				}
				
				bfsQueue.offer(vertexList.get(nowNode).get(i));
				stringBuilderBfs.append(vertexList.get(nowNode).get(i)).append(" ");
				isVisted[vertexList.get(nowNode).get(i)] = true;
			}
		}

	}

}
