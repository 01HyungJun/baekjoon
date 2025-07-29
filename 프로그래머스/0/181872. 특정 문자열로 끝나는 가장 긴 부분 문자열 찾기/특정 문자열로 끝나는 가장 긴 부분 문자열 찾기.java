class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        // while (myString.indexOf(pat) != -1) {
        //     int i = myString.indexOf(pat);
        //     answer = answer + myString.substring(0, i) + pat;
        //     myString = myString.substring(i + pat.length());
        // }
        
        answer = myString.substring(0, myString.lastIndexOf(pat) + pat.length());
        return answer;
    }
}