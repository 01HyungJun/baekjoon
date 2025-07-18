class Solution {
    public String solution(String myString) {
        char[] ch = myString.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'a' || ch[i] == 'A') ch[i] = Character.toUpperCase(ch[i]);
            else ch[i] = Character.toLowerCase(ch[i]);
        }
        return String.valueOf(ch);
    }
}