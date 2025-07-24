import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
//         List<String> list = new ArrayList<>();
        
//         for (int i = 0; i < todo_list.length; i++) {
//             if (!finished[i]) list.add(todo_list[i]);
//         }
        
//         return list.toArray(new String[0]);
        String str = "";
        for (int i = 0; i < todo_list.length; i++) {
            str += !finished[i] ? todo_list[i] + " " : "";
        }
        return str.split(" ");
    }
}