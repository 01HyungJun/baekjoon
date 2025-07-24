class Solution {
    public int solution(int[] num_list) {
        int evenSum = 0, oddSum = 0;
        boolean isOdd = true;
        for (int n : num_list) {
            if (isOdd) oddSum += n;
            else evenSum += n;
            isOdd = !isOdd;
        }
        return evenSum > oddSum ? evenSum : oddSum;
    }
}