class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (char c : my_string.toCharArray()) {
            if ('a' <= c && c <= 'z') {                
                answer[c - 'a' + 26]++;
            }
            else {
                answer[c - 'A']++;
            }
        }
        return answer;
    }
}