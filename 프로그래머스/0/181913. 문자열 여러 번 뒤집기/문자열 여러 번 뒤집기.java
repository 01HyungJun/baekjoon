class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] ch = my_string.toCharArray();
        for(int[] t : queries) {
            boolean isEven = (t[1] - t[0] + 1) % 2 == 0;
            for (int i = 0; i < (t[1] - t[0] + 1) / 2; i++) {
                char temp = ch[t[0] + i];
                ch[t[0] + i] = ch[t[1] - i];
                ch[t[1] - i] = temp;
            }
        }
        return String.valueOf(ch);
    }
}