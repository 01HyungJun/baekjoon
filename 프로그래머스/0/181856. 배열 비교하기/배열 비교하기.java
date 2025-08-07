import java.util.stream.IntStream;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return 1;
        }
        else if (arr1.length < arr2.length) {
            return -1;
        }
        else {
            int a = IntStream.of(arr1).sum();
            int b = IntStream.of(arr2).sum();
            if (a > b) {
                return 1;
            }
            else if(a < b) {
                return -1;
            }
            else return 0;
        }
    }
}