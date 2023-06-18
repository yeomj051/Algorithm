import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
    public static class Node{
        int index;
        int number;
        public Node(int index, int number){
            this.index = index;
            this.number = number;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long result = 0;
        long[][] numberArr = new long[10][N];
        for (int i = 1; i < 10; i++) {
            numberArr[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            numberArr[1][i] = (numberArr[1][i]+numberArr[0][i-1])%1000000000;
            for (int j = 1; j < 9; j++) {
                numberArr[j-1][i] = (numberArr[j-1][i]+numberArr[j][i-1])%1000000000;
                numberArr[j+1][i] = (numberArr[j+1][i]+numberArr[j][i-1])%1000000000;
            }
            numberArr[8][i] = (numberArr[8][i]+numberArr[9][i-1])%1000000000;
        }
        if(N == 1) result =9;
        else{
            for (int i = 0; i <10; i++) {
                result = (result+numberArr[i][N-1])%1000000000;
            }
        }

        StringBuilder stringBuilder = new StringBuilder().append(result%1000000000);
        System.out.println(stringBuilder);
    }
}
