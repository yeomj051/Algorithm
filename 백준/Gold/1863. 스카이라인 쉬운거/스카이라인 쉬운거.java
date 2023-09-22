import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 0; i <= n; i++) {
            int x,y;

            if(i == n) y =0;
            else{
                StringTokenizer st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> record = new Stack<>();
            while(stack.peek() > y){
                int pop = stack.pop();
                if(!record.empty() && record.peek() == pop) continue;
                record.add(pop);
                count++;
            }
            stack.add(y);
        }

        System.out.println(count);

    }
}