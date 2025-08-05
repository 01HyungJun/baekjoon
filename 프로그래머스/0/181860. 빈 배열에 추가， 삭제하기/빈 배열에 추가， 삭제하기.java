import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    deq.addLast(arr[i]);
                }
            }
            else {
                for (int k = 0; k < arr[i]; k++) {
                    deq.removeLast();
                }
            }
        }
        return deq.stream().mapToInt(Integer::intValue).toArray();
    }
}