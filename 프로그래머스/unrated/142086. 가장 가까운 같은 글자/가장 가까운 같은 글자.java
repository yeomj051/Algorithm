class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] array = s.toCharArray();
        int[] alpha = new int[26];
        
        for(int i=0; i<array.length;i++){
            char now = array[i];
            if(alpha[(int)(now-'a')] == 0){
                answer[i] = -1;
                alpha[(int)(now-'a')] = i+1;
            }
            else{
                answer[i] = i - alpha[(int)(now-'a')]+1;
                alpha[(int)(now-'a')] = i+1;                  
            }
        }
        
        return answer;
    }
}