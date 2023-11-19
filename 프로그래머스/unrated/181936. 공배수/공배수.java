class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        answer += number%n;
        answer += number%m;
        
        if(answer > 0) answer = 0;
        else answer = 1;
        
        return answer;
    }
}