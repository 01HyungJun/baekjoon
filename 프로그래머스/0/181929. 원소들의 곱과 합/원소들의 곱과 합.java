import java.util.Arrays;
import java.util.stream.Stream;
class Solution {
    public int solution(int[] num_list) {
        int a = Arrays.stream(num_list).sum();
        int b = Arrays.stream(num_list).reduce(1, (total, num) -> total * num);
        return a * a > b ? 1 : 0;
    }
}