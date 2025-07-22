import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.stream(num_list).boxed().collect(Collectors.toList()));
        List<Integer> answer = list.subList(n, num_list.length);
        answer.addAll(list.subList(0, n));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}