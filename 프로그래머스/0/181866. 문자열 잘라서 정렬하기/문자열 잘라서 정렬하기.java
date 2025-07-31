import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        // String[] answer = myString.split("x", 0);
        // Arrays.sort(answer);
        
        
        
        return Arrays.stream(myString.split("x", 0))
                    .filter(x -> !x.equals(""))
                    .sorted()
                    .toArray(String[]::new);
    }
}