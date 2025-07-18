import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            boolean flag = true;
            for (char ch : String.valueOf(i).toCharArray()) {
                if (ch != '0' && ch != '5') {
                    flag = false;
                    break;
                }
            }
            if (flag) { list.add(i); }
        }
        
        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
}