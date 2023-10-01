import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static int n;
    public static char[][] input;
    public static HashMap<String,Integer> similar;
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new char[n][];
        similar = new HashMap<>();
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();

            String simil = "";
            int count = 1;
            int[] record = new int[26];
            record[(input[i][0] - 'a')] = count;
            simil += count++;

            for (int j = 1; j < input[i].length; j++) {
                if(record[(input[i][j] - 'a')] == 0){
                    record[(input[i][j] - 'a')] = count;
                    simil += count++;
                }else{
                    simil += record[(input[i][j] - 'a')];
                }
            }

            if(similar.containsKey(simil)) similar.replace(simil,similar.get(simil)+1);
            else similar.put(simil,1);
        }

        for (String key : similar.keySet()) {
            int value = similar.get(key);
            if(value > 1) getCount(value,0,0);
        }

        System.out.println(result);
    }

    private static void getCount(int value,int count,int start) {
        if(count == 2){
            result++;
            return;
        }
        for(int i=start; i<value; i++){
            getCount(value,count+1,i+1);
        }
    }

}