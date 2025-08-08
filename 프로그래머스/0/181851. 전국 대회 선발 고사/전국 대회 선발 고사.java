import java.util.Arrays;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] arr = new int[rank.length + 1];
        for(int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                arr[rank[i]] = i;
            }
            else {
                rank[i] = 101;
            }
        }
        Arrays.sort(rank);
        
        return arr[rank[0]] * 10000 + arr[rank[1]] * 100 + arr[rank[2]];
    }
}