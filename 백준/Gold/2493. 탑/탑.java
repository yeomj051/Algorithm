import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.text.TabableView;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int topCount = Integer.parseInt(bufferedReader.readLine());
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		Stack<Tower> stackOrigin = new Stack<>();
		Stack<Tower> stackCompare = new Stack<>();
		int[] resultArr = new int[topCount+1];
		
		for (int i = 1; i <= topCount; i++) {
			Tower tower = new Tower(Integer.parseInt(stringTokenizer.nextToken()), i);
			stackOrigin.push(tower);
		}
		
		while (stackOrigin.size() > 1) {
			stackCompare.push(stackOrigin.pop());
			while (stackOrigin.peek().height > stackCompare.peek().height) {
				resultArr[stackCompare.pop().index] = stackOrigin.peek().index;
				if(stackCompare.isEmpty()) break;
			}
			
		}
		
		StringBuilder stringBuilder =new StringBuilder();
		for (int i = 1; i <= topCount; i++) {
			stringBuilder.append(resultArr[i]).append(" ");
		}
		
		System.out.println(stringBuilder);
		
		
 
	}
	
	static class Tower{
		private int height;
		private int index;
		
		public Tower(int height, int index) {
			super();
			this.height = height;
			this.index = index;
		}
	}
}
