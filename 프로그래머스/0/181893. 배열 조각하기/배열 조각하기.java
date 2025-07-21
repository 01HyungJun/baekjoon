import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            }
            else {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        return arr;
    }
    
//     private int[] copyArr(int[] arr, int start, int end) {
//         int[] result = new int[end - start];
//         for (int i = 0; i < end; i++) {
//             result[i] = arr[start + i];
//         }
//         return result;
//     }
}