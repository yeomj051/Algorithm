class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int bLength = (int)(Math.log10(b)+1);
        int a_b = (int)Math.pow(10, bLength)*a + b;
        
        if(a_b >= 2*a*b) answer = a_b;
        else answer = 2*a*b;
        
        return answer;
    }
}