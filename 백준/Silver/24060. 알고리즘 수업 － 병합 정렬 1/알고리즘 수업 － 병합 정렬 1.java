import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int cnt = 0;
    static int num = 0;
    static boolean flag = false;
    static int[] arr = new int[500000];

    public static void merge_sort(int l, int r) {
        if (l < r) {
            int q = (l + r) / 2;
            merge_sort(l, q);
            if (flag) return;
            merge_sort(q + 1, r);
            if (flag) return;
            merge(l, q, r);
            if (flag) return;
        }
        return;
    }

    public static void merge(int l, int q, int r) {
        int i = l;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            }
            else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }
        
        i = l;
        t = 0;

        while (i <= r) {
            cnt++;
            if (cnt == num) {
                num = tmp[t];
                flag = true;
                return;
            }
            arr[i++] = tmp[t++];
        }

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        num = k;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n - 1);
        System.out.println(cnt >= k ? num : -1);
    }
}