class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(n <= s){
            answer = new int[n];
            
            int num1 = s/n;
            s = s%n;
            for(int i=0; i<n;i++){
                answer[i] = num1;
            }
            if(s > 0){
                int idx = n-1;
                while(s>0){
                    answer[idx--]++;
                    s--;
                }
            }
        }
        
        return answer;
    }
}