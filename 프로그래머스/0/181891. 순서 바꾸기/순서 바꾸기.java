// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list, int n) {
        // List<Integer> list = new ArrayList<>();
        // list.addAll(Arrays.stream(num_list).boxed().collect(Collectors.toList()));
        // List<Integer> answer = list.subList(n, num_list.length);
        // answer.addAll(list.subList(0, n));
        // return answer.stream().mapToInt(Integer::intValue).toArray();
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            if (n == num_list.length) {
                n = 0;
            }
            answer[i] = num_list[n];
            n++;
        }
        return answer;
    }
}