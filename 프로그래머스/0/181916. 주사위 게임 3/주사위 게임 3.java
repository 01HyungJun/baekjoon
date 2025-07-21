// import java.util.Set;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Iterator;
import java.util.Arrays;
class Solution {
    public int solution(int a, int b, int c, int d) {
//         Set<Integer> set = new HashSet<>(List.of(a, b, c, d));
//         Iterator<Integer> it = set.iterator();
//         int[] count = new int[7];
//         count[a]++; count[b]++; count[c]++; count[d]++;
        
//         int p = 0, q = 0, r = 0;
//         switch(set.size()) {
//             case 1:
//                 return 1111 * a;
                
//             case 2:
//                 int flag = 0;
//                 while (it.hasNext()) {
//                     int temp = it.next();
//                     if (count[temp] == 3) p = temp;
//                     else if (count[temp] == 2) {
//                         p = temp;
//                         q = it.next();
//                         flag = 1;
//                         break;
//                     }
//                     else q = temp;
//                 }
//                 return flag == 1 ? (p + q) * Math.abs(p - q) : (int)Math.pow((10 * p + q), 2);
                
//             case 3:
//                 while (it.hasNext()) {
//                     int temp = it.next();
//                     if (count[temp] == 2);
//                     else {
//                         if (q == 0) q = temp;
//                         else r = temp;
//                     }
//                 }
//                 return q * r;
                
//             case 4:
//                 for (int i = 1; i <= 6; i++) {
//                     if (count[i] == 1) return i;
//                 }
//             default:
//                 break;
//         }
//         return 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        
        if (arr[0] == arr[3])
            return 1111 * a;
        else if (arr[0] == arr[2] || arr[1] == arr[3]) {
            return arr[0] == arr[2] ? (int) Math.pow((10 * arr[0] + arr[3]), 2) : (int) Math.pow((10 * arr[1] + arr[0]), 2);
        }
        else if (arr[0] == arr[1] && arr[2] == arr[3]) {
            return (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]);
        }
        else if (arr[0] == arr[1])
            return arr[2] * arr[3];
        else if (arr[1] == arr[2])
            return arr[0] * arr[3];
        else if (arr[2] == arr[3])
            return arr[0] * arr[1];
        else return arr[0];
        
    }
}