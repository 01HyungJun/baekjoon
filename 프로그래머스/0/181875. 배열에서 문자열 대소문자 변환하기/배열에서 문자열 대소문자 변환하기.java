class Solution {
    public String[] solution(String[] strArr) {
        boolean flag = true;
        for (int i = 0; i < strArr.length; i++) {
            if (flag) strArr[i] = strArr[i].toLowerCase();
            else strArr[i] = strArr[i].toUpperCase();
            flag = !flag;
        }
        return strArr;
    }
}