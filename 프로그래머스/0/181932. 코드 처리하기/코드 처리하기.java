class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '1') {
                mode = !mode;
            }
            else if (!mode && (i % 2 == 0)) {
                sb.append(ch);
            }
            else if (mode && (i % 2 != 0)) {
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        return answer.length() == 0 ? "EMPTY" : answer;
    }
}