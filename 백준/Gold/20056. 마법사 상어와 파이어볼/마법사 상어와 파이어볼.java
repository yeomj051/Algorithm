import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Fire{
        int x;
        int y;
        int m;
        int s;
        int d;
        int order;

        public Fire(int x, int y,int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
            this.order = 0;
        }

        public Fire(int x, int y, int m, int s, int d, int order) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
            this.order = order;
        }
    }
    //상 상우 우 하우 하 하좌 좌 상좌
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static int N,M,K;
    public static Queue<Fire> fireList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N*N
        N = Integer.parseInt(st.nextToken());
        //파이어볼 갯수
        M = Integer.parseInt(st.nextToken());
        //명령 횟수
        K = Integer.parseInt(st.nextToken());
        
        //x y 질량 속력 방향
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fire newFire = new Fire(x,y,m,s,d);
            fireList.add(newFire);
        }

        for (int order = 0; order < K; order++) {
            ArrayList<Fire>[][] subMap = new ArrayList[N+1][N+1];

            while(!fireList.isEmpty() && fireList.peek().order == order){
                Fire nowFire = fireList.poll();
                int nx = nowFire.x + (dx[nowFire.d]* nowFire.s);
                int ny = nowFire.y + (dy[nowFire.d]* nowFire.s);

                while(nx < 1 || ny < 1 || nx > N || ny > N){
                    if(nx<1) nx = N + nx;
                    else if(nx>N) nx = nx - N;
                    if(ny<1) ny = N + ny;
                    else if(ny>N) ny = ny - N;
                }

                nowFire.x = nx;
                nowFire.y = ny;
                if(subMap[nx][ny] == null) subMap[nx][ny] = new ArrayList<>();
                subMap[nx][ny].add(nowFire);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(subMap[i][j] != null && subMap[i][j].size() > 1){
                        int totalM = 0;
                        int totalS = 0;
                        int totalD = subMap[i][j].get(0).d%2;

                        for (Fire nowFire : subMap[i][j]) {
                            totalM += nowFire.m;
                            totalS += nowFire.s;

                            if(totalD > 1) continue;
                            else if((totalD == 0 && totalD != (totalD + nowFire.d) % 2)
                            ||(totalD == 1 && totalD == (totalD + nowFire.d) % 2)) totalD = 3;
                        }
                        if(totalD != 3) totalD=4;

                        if(totalM/5 == 0) continue;
                        for (int k = 0; k < 8; k+=2) {
                            Fire newFire = new Fire(i,j,totalM/5,totalS/subMap[i][j].size(),totalD%2+k,order+1);
                            fireList.add(newFire);
                        }
                    }else if(subMap[i][j] != null){
                        subMap[i][j].get(0).order++;
                        fireList.add(subMap[i][j].get(0));
                    }
                }
            }
        }

        int result = 0;
        while(!fireList.isEmpty()){
            result += fireList.poll().m;
        }

        System.out.println(result);
    }
}