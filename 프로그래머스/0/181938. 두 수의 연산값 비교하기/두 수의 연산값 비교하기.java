class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        String s = sb.append(a).append(b).toString();
        int answer = Integer.parseInt(s) >= (2 * a * b) ? Integer.parseInt(s) : (2 * a * b);
        return answer;
    }
}