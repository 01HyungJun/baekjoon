class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replace("A", "a");
        myString = myString.replace("B", "A");
        myString = myString.replace("a", "B");
        
        return myString.contains(pat) ? 1 : 0;
    }
}