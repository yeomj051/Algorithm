import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int nodeSize;
    private static int lineSize;
    private static int startNode;
    private static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nodeSize = Integer.parseInt(stringTokenizer.nextToken());
        lineSize = Integer.parseInt(stringTokenizer.nextToken());
        startNode = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList[nodeSize + 1];

        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineSize; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int score = Integer.parseInt(stringTokenizer.nextToken());

            graph[start].add(new Edge(end, score));
        }

        int[] result = dijkstra(startNode);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= nodeSize; i++) {
            if (result[i] == Integer.MAX_VALUE) stringBuilder.append("INF");
            else stringBuilder.append(result[i]);
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static int[] dijkstra(int startNode) {
        int[] dp = new int[nodeSize + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[startNode] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            int currentNode = current.end;
            int currentWeight = current.weight;

            if (currentWeight > dp[currentNode]) continue;

            for (Edge edge : graph[currentNode]) {
                int nextNode = edge.end;
                int nextWeight = edge.weight;

                if (dp[nextNode] > dp[currentNode] + nextWeight) {
                    dp[nextNode] = dp[currentNode] + nextWeight;
                    priorityQueue.offer(new Edge(nextNode, dp[nextNode]));
                }
            }
        }

        return dp;
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
