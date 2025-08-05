import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deq = new ArrayDeque<>();
        int i = 0;
        while (i < arr.length) {
            if (deq.isEmpty()) {
                deq.addLast(arr[i]);
            }
            else if (deq.peekLast() == arr[i]) {
                deq.removeLast();
            }
            else {
                deq.addLast(arr[i]);
            }
            i++;
        }
        return deq.isEmpty() ? new int[]{-1} : deq.stream().mapToInt(Integer::intValue).toArray();
    }
}