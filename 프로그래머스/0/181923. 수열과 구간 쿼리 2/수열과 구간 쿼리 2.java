import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for(int[] t : queries) {
            int m = 1000001;
            for (int i = t[0]; i <= t[1]; i++) {
                if ((arr[i] > t[2]) && (m > arr[i])) {
                    m = arr[i];
                }
            }
            if (m != 1000001) list.add(m);
            else list.add(-1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}