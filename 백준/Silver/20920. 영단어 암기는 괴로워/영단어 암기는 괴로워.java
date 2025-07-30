import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if (temp.length() < m)
                continue;

            wordMap.put(temp, wordMap.getOrDefault(temp, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(wordMap.keySet());
        
        wordList.sort((a, b) -> {
            if (wordMap.get(a) != wordMap.get(b))
                return wordMap.get(b) - wordMap.get(a);

            if (a.length() != b.length())
                return b.length() - a.length();
            
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : wordList) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}