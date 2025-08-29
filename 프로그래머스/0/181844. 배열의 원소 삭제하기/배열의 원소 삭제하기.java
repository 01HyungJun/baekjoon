import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (Integer i : delete_list) {
            if (list.contains(i)) {
                list.remove(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}