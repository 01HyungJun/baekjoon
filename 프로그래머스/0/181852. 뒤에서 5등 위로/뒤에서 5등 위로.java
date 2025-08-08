import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int[] arr = Arrays.copyOfRange(num_list, 5, num_list.length);
        return arr;
    }
}