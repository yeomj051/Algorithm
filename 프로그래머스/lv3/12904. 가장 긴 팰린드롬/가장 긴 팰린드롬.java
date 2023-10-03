class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] sToChar = s.toCharArray();
        int totalSize = sToChar.length;
       
        for(int i=totalSize; i>1; i--){
            int start = 0;
            
            while(start+(i-1) < totalSize){
                boolean flag = true;
                
                for(int j=0; j<i/2; j++){
                    if(sToChar[start+j] != sToChar[start+(i-1)-j]) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    answer = i;
                    return answer;
                }
                start++;
            }
        }

        answer = 1;
        return answer;
    }
}