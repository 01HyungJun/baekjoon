import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        int i = 1;
        while(n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                answer.add(n);
            }
            else {
                n = 3 * n + 1;
                answer.add(n);
            }
            i++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}