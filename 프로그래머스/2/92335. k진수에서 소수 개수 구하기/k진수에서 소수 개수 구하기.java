import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> change = new Stack<>();
        
        while(n > 0){
            change.push(n%k);
            n = n/k;
        }
        
        while(!change.isEmpty()){
            long num = 0;
            while(!change.isEmpty() && change.peek() != 0){
                num = num*10 + change.pop();
            }
            System.out.println(num);
            
            if(isPrime(num)) answer++;
            
            while(!change.isEmpty() && change.peek() == 0) change.pop();
        }
        return answer;
    }
    
    public static boolean isPrime(long number){
        if(number == 1)  return false;
        
        long a = (long)Math.sqrt(number) + 1;
        
        for(int i=2;i<a;i++) {
            if(number%i == 0) return false;
        }
        
        return true;
    }
}