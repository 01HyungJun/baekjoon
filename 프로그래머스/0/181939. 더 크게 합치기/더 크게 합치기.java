class Solution {
    public int solution(int a, int b) {
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        
        if(Integer.valueOf(str1) >= Integer.valueOf(str2))
            return Integer.valueOf(str1);
        else
            return Integer.valueOf(str2);
    }
}