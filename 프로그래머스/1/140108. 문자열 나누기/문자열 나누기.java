class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] charList = s.toCharArray();
        
        for(int i=0; i<charList.length;i++){
            char x = charList[i];
            int xSize = 1;
            int oSize = 0;
            while(i<charList.length-1 && xSize > oSize){
                if(charList[++i] == x) xSize++;
                else oSize++;
            }
            answer++;
        }
        
        return answer;
    }
}