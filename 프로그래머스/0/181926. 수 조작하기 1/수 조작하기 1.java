class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(char ch : control.toCharArray()){
            if ('w' == ch){
                answer += 1;
            }
            else if ('s' == ch){
                answer -= 1;
            }
            else if ('d' == ch){
                answer += 10;
            }
            else answer -= 10;
        }
        return answer;
    }
}