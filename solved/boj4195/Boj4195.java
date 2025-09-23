import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj4195 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj4195().solution();
    }

    int T, F;
    int[] parents, size;
    Map<String, Integer> map;

    void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());
            int cnt = 1;
            parents = new int[2 * F + 1];
            size = new int[2 * F + 1];
            for (int i = 1; i <= 2 * F; i++) {
                parents[i] = i;
                size[i] = 1;
            }
            map = new HashMap<>();

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();

                if (!map.containsKey(str1)) map.put(str1, cnt++);
                if (!map.containsKey(str2)) map.put(str2, cnt++);

                int a = map.get(str1);
                int b = map.get(str2);

                wr.write(union(a, b) + "\n");
            }
        }
        wr.flush();
    }

    int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
            size[a] += size[b];
            size[b] = size[a];
        }
        return size[a];
    }
}