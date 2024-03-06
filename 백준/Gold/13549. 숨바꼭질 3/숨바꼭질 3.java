import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int old,young;
    public static class Node{
        int time;
        int position;

        public Node(int time, int position) {
            this.time = time;
            this.position = position;
        }
    }
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        old = Integer.parseInt(st.nextToken());
        young = Integer.parseInt(st.nextToken());

        if(old == young){
            System.out.println(0);
        }else System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node> q = new LinkedList<>();
        int[] visit = new int[Math.max(young,old)*2];
        Arrays.fill(visit,Integer.MAX_VALUE);
        Node start = new Node(0,old);
        visit[old] = 0;
        q.add(start);

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.position < young){
                Node newNode = new Node(now.time, now.position*2);
                if(visit[newNode.position] > newNode.time){
                    visit[newNode.position] = newNode.time;
                    q.add(newNode);
                }

                newNode = new Node(now.time+1, now.position+1);
                if(visit[newNode.position] > newNode.time){
                    visit[newNode.position] = newNode.time;
                    q.add(newNode);
                }
            }

            if(now.position > 0){
                Node newNode = new Node(now.time+1, now.position-1);
                if(visit[newNode.position] > newNode.time){
                    visit[newNode.position] = newNode.time;
                    q.add(newNode);
                }
            }

        }
        
        return visit[young];
    }
}