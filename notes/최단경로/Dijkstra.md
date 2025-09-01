# 다익스트라 알고리즘 (Dijkstra Algorithm)

> 가중치가 있는 그래프에서 하나의 시작 정점으로부터 다른 모든 정점까지의 최단 경로를 찾는 알고리즘.

* **음의 가중치 간선은 허용하지 않음**
* 우선순위 큐를 활용하면 효율적으로 구현 가능

---

## 개념

* 시작 정점 `s`에서 다른 모든 정점까지의 최단 거리를 구한다.
* 탐욕적(Greedy) 방법을 기반으로 동작한다.
* 동작 방식은 **Prim 알고리즘**과 유사하나, MST가 아닌 최단 경로를 구한다는 점에서 다르다.

---

## 의사코드 (Pseudo-code)

```pseudo
s : 시작 정점
A : 인접 행렬 (가중치 저장)
D : 시작 정점에서 각 정점까지의 거리
V : 모든 정점 집합
U : 선택된 정점 집합 (최단 경로 확정된 집합)

Dijkstra(s, A, D)
    U = {s}

    FOR 모든 정점 v
        D[v] <- A[s][v]

    WHILE U != V
        w = D[w]가 최소인 정점 w ∈ (V - U) 선택
        U <- U ∪ {w}

        FOR w에 인접한 모든 미방문 정점 v
            D[v] <- min(D[v], D[w] + A[w][v])
```

---

## 시간 복잡도

* 인접 행렬 + 배열: **O(V²)**
* 인접 리스트 + 우선순위 큐(힙): **O(E log V)**

---

## 자바 구현 (PriorityQueue 활용)

```java
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class DijkstraPQ {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, M;
    List<Node>[] graph;
    int[] dist;
    final int INF = 1_000_000_000;

    void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.v] < cur.w) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            // 양방향 그래프라면 아래 라인 유지
            // graph[v].add(new Node(u, w));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        int start = Integer.parseInt(br.readLine());
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        new DijkstraPQ().solution();
    }
}

```

---

## 입력 형식

```
정점 개수 V, 간선 개수 E, 시작 정점
u v w
u v w
...
```

## 예시 입력

```
5 6 1
1 2 2
1 3 5
2 3 1
2 4 2
3 5 3
4 5 1
```

## 출력

```
정점 1까지 최단 거리: 0
정점 2까지 최단 거리: 2
정점 3까지 최단 거리: 3
정점 4까지 최단 거리: 4
정점 5까지 최단 거리: 5
```
