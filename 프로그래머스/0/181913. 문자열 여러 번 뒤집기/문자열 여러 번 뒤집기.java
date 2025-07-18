class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] ch = my_string.toCharArray();
        for(int[] t : queries) {
            boolean isEven = (t[1] - t[0] + 1) % 2 == 0;
            for (; t[1] > t[0]; t[0]++, t[1]--) {
                char temp = ch[t[0]];
                ch[t[0]] = ch[t[1]];
                ch[t[1]] = temp;
            }
        }
        return String.valueOf(ch);
    }
}