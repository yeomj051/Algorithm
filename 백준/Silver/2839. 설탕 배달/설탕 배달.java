import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int totalKG = Integer.parseInt(bufferedReader.readLine());
		int count = 0;
		
		for (int i = totalKG/5; i >= 0; i--) {
			int rest = 0;
			if(i==0) rest = totalKG;
			else rest = (totalKG-(5*i));
			if(rest % 3 ==0) {
				count = i + rest/3;
				break;
			}
			count = -1;
		}
		
		StringBuilder stringBuilder = new StringBuilder().append(count);
		System.out.println(stringBuilder);
	}

}
