import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String S,T;
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(result);
    }

    public static void dfs(String str){
        if(S.length() == str.length()){
            if(S.equals(str)) result = 1;
            return;
        }

        if(result == 0){
            if(str.charAt(str.length()-1) == 'A'){
                dfs(str.substring(0,str.length()-1));
            }
            if(str.charAt(0) == 'B'){
                StringBuilder sb = new StringBuilder().append(str.substring(1,str.length()));
                dfs(sb.reverse().toString());
            }
        }
    }
}