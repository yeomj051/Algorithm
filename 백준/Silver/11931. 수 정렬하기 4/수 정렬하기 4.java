import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();
        
        int[] numArr = new int[sc.nextInt()];
        
        for (int i = 0; i < numArr.length; i++) {
			numArr[i] = sc.nextInt();
		}
        
        Arrays.sort(numArr);
        
        for (int i = numArr.length-1 ; i >= 0; i--) {
        	stringBuilder.append(numArr[i]).append("\n");
		}
        System.out.println(stringBuilder);
	}

}
