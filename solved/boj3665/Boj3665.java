import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3665 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj3665().solution();
    }

    int N, M;
    int[] team;
    ArrayList<Integer>[] graph;
    int[] inD;

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 입력 처리
            N = Integer.parseInt(br.readLine());
            team = new int[N];
            graph = new ArrayList[N + 1];
            inD = new int[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) team[i] = Integer.parseInt(st.nextToken());

            // 작년 순위 기반 그래프 구성
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int from = team[i];
                    int to = team[j];
                    graph[from].add(to);
                    inD[to]++;
                }
            }

            // 순위 변경 반영
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                // 간선 방향 뒤집기
                if (graph[from].contains(to)) {
                    graph[from].remove((Integer) to);
                    inD[to]--;
                    graph[to].add(from);
                    inD[from]++;
                } else {
                    graph[to].remove((Integer) from);
                    inD[from]--;
                    graph[from].add(to);
                    inD[to]++;
                }
            }

            // 위상 정렬 시작
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inD[i] == 0) q.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            boolean certain = true;
            int cnt = 0;

            while (!q.isEmpty()) {
                // 여러 순위 가능성 존재
                if (q.size() > 1) {
                    certain = false;
                    break;
                }

                int n = q.poll();
                sb.append(n).append(" ");
                cnt++;

                for (int nxt : graph[n]) {
                    inD[nxt]--;
                    if (inD[nxt] == 0) q.offer(nxt);
                }
            }

            // 결과 출력
            if (!certain) System.out.println("?");
            else if (cnt != N) System.out.println("IMPOSSIBLE");
            else System.out.println(sb.toString().trim());
        }

        br.close();
    }
}
