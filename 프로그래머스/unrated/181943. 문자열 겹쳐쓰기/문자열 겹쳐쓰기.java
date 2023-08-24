class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] myChar = my_string.toCharArray();
        char[] overChar = overwrite_string.toCharArray();
        
        int count = 0;
        for(int i=0; i<myChar.length;i++){
            
            if(i >= s && count < overChar.length){
                answer += overChar[count];
                count++;
            }else answer += myChar[i];
            
        }
        
        return answer;
    }
}