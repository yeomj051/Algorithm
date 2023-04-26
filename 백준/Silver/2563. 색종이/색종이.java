import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int paperCount = Integer.parseInt(bufferedReader.readLine());
        int[][] whitePaperArr = new int[100][100];

        for (int i = 0; i < paperCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int xNum = Integer.parseInt(stringTokenizer.nextToken());
                int yNum = Integer.parseInt(stringTokenizer.nextToken());


                for (int x = xNum; x < xNum + 10; x++) {
                    for (int y = yNum; y < yNum + 10; y++) {
                        whitePaperArr[x][y] =1;

                    }
                }

        }

        int count =0;
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                if (whitePaperArr[j][k] ==1) count++;
            }
        }
        System.out.println(count);

    }
}
