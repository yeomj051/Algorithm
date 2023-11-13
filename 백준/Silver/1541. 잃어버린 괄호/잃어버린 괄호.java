import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		
		//"-"로 구분한 식을 담을 stack(괄호로 묶을 식을 담을 stack)
		Stack<String> stack1 = new Stack<>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(),"-");

		for (int i = 0, size1 = stringTokenizer.countTokens() ; i < size1; i++) {
			String string = stringTokenizer.nextToken();
			stack1.push(string);
		}
		
		//괄호 안희 식을 "+"로 구분하고 더해주기
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0, size = stack1.size(); i < size; i++) {
			stringTokenizer = new StringTokenizer(stack1.pop(),"+");
			int sum = 0;
			for (int j = 0, size2 = stringTokenizer.countTokens() ; j < size2; j++) {
				sum += Integer.parseInt(stringTokenizer.nextToken());
			}
			stack2.push(sum);
		}
		
		int result = stack2.pop();
		for (int i = 0, size3=stack2.size() ; i < size3; i++) {
			result -= stack2.pop();
		}
		
		System.out.println(result);
		
	}

}
