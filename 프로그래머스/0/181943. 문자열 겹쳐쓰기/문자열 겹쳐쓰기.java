class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char [] ch = new char [my_string.length()];
        ch = my_string.toCharArray();
        for (int i = s; i < s + overwrite_string.length(); i++){
            ch[i] = overwrite_string.charAt(i - s);
        }
        String answer = String.valueOf(ch);
        return answer;
    }
}