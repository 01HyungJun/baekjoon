class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        char[] ch = code.toCharArray();
        boolean mode = false;
        
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                mode = !mode;
            }
            else if (!mode && (i % 2 == 0)) {
                sb.append(ch[i]);
            }
            else if (mode && (i % 2 != 0)) {
                sb.append(ch[i]);
            }
        }
        String answer = sb.toString();
        return answer.length() == 0 ? "EMPTY" : answer;
    }
}