class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String aString = Integer.toString(a);
        String bString = Integer.toString(b);
        
        if(Integer.valueOf(aString+bString) > Integer.valueOf(bString+aString)) answer = Integer.valueOf(aString+bString);
        else answer = Integer.valueOf(bString+aString);
        
        return answer;
    }
}