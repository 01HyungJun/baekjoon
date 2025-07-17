class Solution {
    public int solution(int a, int b) {
        int answer = Integer.parseInt("" + a + b) >= (2 * a * b) ? Integer.parseInt("" + a + b) : (2 * a * b);
        return answer;
    }
}