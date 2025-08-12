import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 입출력을 위한 BufferedReader와 BufferedWriter를 클래스 멤버 변수로 선언합니다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    // N: 도시의 개수, K: 찾고자 하는 최단 거리, X: 출발 도시 번호
    int N, K, X;
    // 그래프를 인접 리스트로 표현하기 위한 List 배열
    List<Integer>[] graph;
    // 방문 여부와 시작 도시로부터의 거리를 저장하는 배열
    int[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        visited = new int[N + 1];

        bfs(X);

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == K + 1) {
                sb.append(i).append("\n");
                flag = true;
            }
        }

        if (flag) {
            wr.write(sb.toString());
        } else {
            wr.write("-1");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        
        visited[start] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph[cur]) {
                if (visited[nxt] == 0) {
                    visited[nxt] = visited[cur] + 1;
                    q.offer(nxt);
                }
            }
        }
    }
}
