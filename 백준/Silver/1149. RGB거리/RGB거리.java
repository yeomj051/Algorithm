import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //집의 수
        int houseConut = Integer.parseInt(bufferedReader.readLine());
        //각 집의 칠하는 비용 배열
        int[][] costArr = new int[houseConut][3];
        for (int i = 0; i < houseConut; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                costArr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // dp배열 - 최대값으로 채운다.
        int[][] dpArr = new int[houseConut][3];

        //dp배열의 0번째 배열을 시작으로 한다.
        for (int i = 0; i < 3; i++) {
            dpArr[0][i] = costArr[0][i];
        }

        for (int i = 1; i < houseConut; i++) {
            dpArr[i][0] = costArr[i][0] + Math.min(dpArr[i-1][1],dpArr[i-1][2]);
            dpArr[i][1] = costArr[i][1] + Math.min(dpArr[i-1][0],dpArr[i-1][2]);
            dpArr[i][2] = costArr[i][2] + Math.min(dpArr[i-1][0],dpArr[i-1][1]);
        }

        System.out.println(Math.min(dpArr[houseConut-1][0],Math.min(dpArr[houseConut-1][1],dpArr[houseConut-1][2])));
    }
}
