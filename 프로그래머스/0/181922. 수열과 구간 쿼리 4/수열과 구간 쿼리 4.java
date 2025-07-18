class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] t : queries) {
            int i = t[0];
            while (i <= t[1]) {
                if (i % t[2] == 0) {
                    arr[i]++;
                    i += t[2];
                    continue;
                }
                i++;
            }
        }
        return arr;
    }
}