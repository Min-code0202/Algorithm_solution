import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj24480 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    int N, M, R;
    ArrayList<Integer>[] graph;
    int[] visited;
    int cnt = 1;

    public static void main(String[] args) throws IOException {
        new Boj24480().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 입력 다 받은 후 정렬 (내림차순)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        visited = new int[N + 1];
        dfs(R);

        for (int i = 1; i <= N; i++) {
            wr.write(visited[i] + "\n");
        }
        wr.flush();
    }

    void dfs(int s) {
        visited[s] = cnt++;
        for (int nxt : graph[s]) {
            if (visited[nxt] == 0) {
                dfs(nxt);
            }
        }
    }
}
