// import java.util.HashMap;
// import java.util.Map;
class Solution {
    public int solution(String[] order) {
        int answer = 0;
        // Map<String, Integer> map = new HashMap<>();
        // map.put("iceamericano", 4500);
        // map.put("americanoice", 4500);
        // map.put("americano", 4500);
        // map.put("anything", 4500);
        // map.put("hotamericano", 4500);
        // map.put("americanohot", 1);
        // map.put("icecafelatte", 2);
        // map.put("cafelatteice", 2);
        // map.put("cafelatte", 2);
        // map.put("hotcafelatte", 3);
        // map.put("cafelattehot", 3);
        
        for (String s : order) {
            if (s.contains("americano") || s.contains("anything")) {
                answer += 4500;
            }
            else {
                answer += 5000;
            }
        }
        
        return answer;
    }
}