class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        boolean flag = k % 2 == 0;
        for (int i = 0; i < arr.length; i++) {
            answer[i] = flag ? arr[i] + k : arr[i] * k;
        }
        return answer;
    }
}