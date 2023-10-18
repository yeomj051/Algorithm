class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(n <= s){
            answer = new int[n];
            
            int num1 = s/n;
            s = s%n;
            
            for(int i=n-1; i>=0;i--){
                answer[i] = num1;
                if(s>0){
                    answer[i]++;
                    s--;
                }
            }
        }
        
        return answer;
    }
}