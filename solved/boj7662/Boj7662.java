import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj7662().solution();
    }

    int T, k;

    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (order == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (order == 'D') {
                    if (map.isEmpty())
                        continue;
                    int targetKey = (n == -1) ? map.firstKey() : map.lastKey();
                    int cnt = map.get(targetKey);
                    if (cnt > 0) {
                        if (cnt > 1) {
                            map.put(targetKey, cnt - 1);
                        } else {
                            map.remove(targetKey);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}