import java.util.List;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] picture, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (String s : picture) {
            for (char ch : s.toCharArray()) {
                for (int j = 0; j < k; j++) {
                    sb.append(ch);
                }
            }
            for (int i = 0; i < k; i++) {
                list.add(sb.toString());
            }
            sb.setLength(0);
        }
        
        return list.toArray(new String[0]);
    }
}