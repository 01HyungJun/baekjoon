class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] array = new int[start_num - end_num + 1];
        int idx = 0;
        for (int i = start_num; i >= end_num; i--) {
            array[idx++] = i;
        }
        return array;
    }
}