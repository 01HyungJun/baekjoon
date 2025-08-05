// import java.util.List;
// import java.util.ArrayList;
import java.util.StringTokenizer;
class Solution {
    public String[] solution(String myStr) {
//         List<String> list = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
        
//         for (char ch : myStr.toCharArray()) {
//             switch (ch) {
//                 case 'a': case 'b': case 'c':
//                     if (sb.length() != 0) {
//                         list.add(sb.toString());
//                         sb.setLength(0);
//                     }
//                     break;
//                 default:
//                     sb.append(ch);
//                     break;
//             }
//         }
//         if (sb.length() != 0) {
//             list.add(sb.toString());
//             sb.setLength(0);
//         }
//         if (list.size() == 0) {
//             return new String[]{"EMPTY"};
//         }
//         return list.toArray(new String[0]);
        String[] answer;
        StringTokenizer st = new StringTokenizer(myStr, "abc");
        if (st.hasMoreTokens()) {
            answer = new String[st.countTokens()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = st.nextToken();
            }
        }
        else {
            return new String[]{"EMPTY"};
        }
        return answer;
    }
}