// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int l, int r) {
//         List<Integer> list = new ArrayList<>();
        
//         for (int i = l; i <= r; i++) {
//             boolean flag = true;
//             for (char ch : String.valueOf(i).toCharArray()) {
//                 if (ch != '0' && ch != '5') {
//                     flag = false;
//                     break;
//                 }
//             }
//             if (flag) { list.add(i); }
//         }
        
//         return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
        int[] array = IntStream.rangeClosed(l, r)
            .filter(i -> {
                while (i > 0) {
                    if (i % 5 != 0) return false;
                    i /= 10;
                }
                return true;
            }).toArray();
        return array.length == 0 ? new int[]{-1} : array;
    }
}