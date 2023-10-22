import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> chainList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            chainList.add(Integer.parseInt(st.nextToken()));
        }

        chainList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int result = 0;
        while(chainList.size() > 1){
            int smallest = chainList.remove(0);
            int connect = chainList.remove(chainList.size()-1);
            for (int i = smallest; i > 0 && chainList.size() > 0; i--) {
                connect += chainList.remove(chainList.size()-1)+1;
                smallest--;
                result++;
            }

            if(smallest > 0){
                connect += smallest;
                result++;
            }
            chainList.add(connect);
        }

        System.out.println(result);
    }
}