import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = k; i <= n; i += k) {
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}