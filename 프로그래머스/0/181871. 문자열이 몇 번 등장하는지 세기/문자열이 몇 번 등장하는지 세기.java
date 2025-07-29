class Solution {
    public int solution(String myString, String pat) {
        int idx = 0, cnt = 0;
        
        while ((idx = myString.indexOf(pat)) != -1) {
            cnt++;
            myString = myString.substring(myString.indexOf(pat) + 1);
        }
        
        return cnt;
    }
}