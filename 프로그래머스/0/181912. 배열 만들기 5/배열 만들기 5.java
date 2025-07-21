import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for (String st : intStrs) {
            int temp = Integer.parseInt(st.substring(s, s + l));
            if (temp > k) {
                list.add(temp);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}