import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1707 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1707().solution();
    }

    int K, V, E;
    List<Integer>[] graph;
    int[] visited;

    void solution() throws IOException {
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            // -1 : 방문 안함 (0, 1) : 해당 번호로 색칠
            visited = new int[V + 1];
            Arrays.fill(visited, -1);

            String ans = "YES";
            for (int i = 1; i <= V; i++) {
                if (visited[i] == -1) { // 방문 안 한 정점에서 DFS 시작
                    if (dfs(i, 1).equals("NO")) {
                        ans = "NO";
                        break;
                    }
                }
            }

            wr.write(ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    String dfs(int c, int color) {
        visited[c] = color;

        for (int n : graph[c]) {
            if (visited[n] != -1 && visited[n] == color) {  // 같은 색이면 이분 그래프 아님
                return "NO";
            }
            if (visited[n] == -1) {
                String res = dfs(n, 1 - color);
                if (res.equals("NO")) { // 하위 DFS에서 NO 나오면 바로 중단
                    return "NO";
                }
            }
        }
        return "YES";
    }
}