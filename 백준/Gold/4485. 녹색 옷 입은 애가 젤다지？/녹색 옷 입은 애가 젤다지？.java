import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Vertex {
		int x;
		int y;
		int coin;

		public Vertex(int x, int y, int coin) {
			super();
			this.x = x;
			this.y = y;
			this.coin = coin;
		}
	}

	static Vertex[][] cave;
	static int caveSize;

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상 우 하 좌

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int testcase = 1;

		StringBuilder stringBuilder = new StringBuilder();

		while (true) {

			caveSize = Integer.parseInt(bufferedReader.readLine());

			if (caveSize == 0) {
				break;
			}

			cave = new Vertex[caveSize][caveSize];

			for (int i = 0; i < caveSize; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < caveSize; j++) {
					Vertex vertex = new Vertex(i, j, Integer.parseInt(stringTokenizer.nextToken()));
					cave[i][j] = vertex;
				}
			}

			int sum = digkstra();

			stringBuilder.append("Problem ").append(testcase).append(": ").append(sum).append("\n");

			testcase++;
		}

		System.out.println(stringBuilder);
	}

	private static int digkstra() {
		int[][] blackCoin = new int[caveSize][caveSize];
		boolean[][] visit = new boolean[caveSize][caveSize];

		for (int i = 0; i < blackCoin.length; i++) {
			Arrays.fill(blackCoin[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Vertex> queue = new PriorityQueue<>((e1, e2) -> e1.coin - e2.coin);

		queue.offer(cave[0][0]);
		blackCoin[0][0] = cave[0][0].coin;

		while (!queue.isEmpty()) {

			Vertex nowVertex = queue.poll();

			if (visit[nowVertex.x][nowVertex.y]) continue;

			visit[nowVertex.x][nowVertex.y] = true;


			for (int i = 0; i < delta.length; i++) {
				
				int nextX = nowVertex.x + delta[i][0];
				int nextY = nowVertex.y + delta[i][1];
				
				if (nextX < caveSize && nextY < caveSize && nextX >= 0 && nextY >= 0 && !visit[nextX][nextY]) {
					if (blackCoin[nextX][nextY] > cave[nextX][nextY].coin + nowVertex.coin) {
						blackCoin[nextX][nextY] = cave[nextX][nextY].coin + nowVertex.coin;
						queue.offer(new Vertex(nextX, nextY, blackCoin[nextX][nextY]));
					}
				}
			}
		}

		return blackCoin[caveSize - 1][caveSize - 1];
	}

}
