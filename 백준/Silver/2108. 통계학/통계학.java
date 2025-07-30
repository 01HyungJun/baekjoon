import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        Arrays.sort(arr);
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        int maxKey1 = Integer.MAX_VALUE, maxKey2 = Integer.MAX_VALUE;
        int maxVal = 0;
        while (it.hasNext()) {
            int k = it.next();
            if (map.get(k) > maxVal) {
                maxVal = map.get(k);
                maxKey1 = k;
                maxKey2 = Integer.MAX_VALUE;
            }
            else if (map.get(k) == maxVal) {
                if (maxKey1 > k) {
                    maxKey2 = maxKey1;
                    maxKey1 = k;
                }
                else if (maxKey2 > k) {
                    maxKey2 = k;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((int) Math.round(sum / (double) n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        sb.append(maxKey2 == Integer.MAX_VALUE ? maxKey1 : maxKey2).append("\n");
        sb.append(arr[n - 1] - arr[0]).append("\n");

        System.out.println(sb);
    }
}