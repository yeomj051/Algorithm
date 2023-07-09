import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a).append(b);
        System.out.println(stringBuilder);
    }
}