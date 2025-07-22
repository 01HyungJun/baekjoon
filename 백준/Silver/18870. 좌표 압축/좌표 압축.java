import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (String s : tokens) {
            arr[i++] = Integer.parseInt(s);
            set.add(Integer.parseInt(s));
        }

        int[] narr = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        i = 0;
        while (it.hasNext()) {
            narr[i++] = it.next();
        }

        Arrays.sort(narr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < narr.length; j++) {
            map.put(narr[j], j);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(map.get(a)).append(" ");
        }

        System.out.println(sb);
    }
}