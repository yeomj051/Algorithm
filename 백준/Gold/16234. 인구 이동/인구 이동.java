import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N,L,R;
    public static int[][] map,union;
    public static ArrayList<ArrayList<Point>> unionCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int day = 0;
        do{
            unionCnt = new ArrayList<>();
            union = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(union[i][j] == 0){
                        bfs(new Point(i,j));
                    }
                }
            }
            if(unionCnt.size() > 0) {
                day++;
                for (int i = 0; i < unionCnt.size(); i++) {
                    int lastIdx = unionCnt.get(i).size()-1;
                    int totalPeople = unionCnt.get(i).get(lastIdx).x;
                    int totalCount = unionCnt.get(i).get(lastIdx).y;
                    int result = totalPeople / totalCount;
                    for (int j = 0; j < unionCnt.get(i).size()-1; j++) {
                        Point now = unionCnt.get(i).get(j);
                        map[now.x][now.y] = result;
                    }
                }
            }

        }
        while(unionCnt.size() > 0);

        System.out.println(day);

    }

    private static void bfs(Point start) {
        Queue<Point> queue= new LinkedList<>();
        int totalPeople = map[start.x][start.y];
        queue.add(start);
        ArrayList<Point> unionList = new ArrayList<>();
        unionList.add(start);
        union[start.x][start.y] = unionCnt.size()+1;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || union[nx][ny] != 0) continue;

                int diff = (int) Math.abs(map[now.x][now.y] - map[nx][ny]);
                if(diff < L|| diff > R ) continue;

                union[nx][ny] = unionCnt.size()+1;
                totalPeople += map[nx][ny];
                Point nextPoint = new Point(nx,ny);
                queue.add(nextPoint);
                unionList.add(nextPoint);
            }
        }

        if(unionList.size() == 1){
            return;
        }
        unionList.add(new Point(totalPeople,unionList.size()));
        unionCnt.add(unionList);
    }
}