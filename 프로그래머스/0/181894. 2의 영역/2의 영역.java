import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        int start = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) {
                    list.removeAll(list);
                    list.add(2);
                }
                else {
                    for (int j = start; j <= i; j++) {
                        list.add(arr[j]);
                    }
                }
                start = i + 1;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}