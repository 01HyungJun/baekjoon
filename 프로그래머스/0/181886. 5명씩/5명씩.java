class Solution {
    public String[] solution(String[] names) {
        String[] arr = new String[names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1];
        for (int i = 0; i < names.length; i += 5) {
            arr[i / 5] = names[i];
        }
        return arr;
    }
}