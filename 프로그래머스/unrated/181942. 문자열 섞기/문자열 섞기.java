class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        
        int count = 0;
        while(count < char1.length){
            answer += char1[count];
            answer += char2[count];
            count++;
        }
        
        return answer;
    }
}