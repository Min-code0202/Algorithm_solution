# 최소 신장 트리 (Minimum Spanning Tree, MST)

모든 정점을 연결하는 간선들의 **가중치 합이 최소**가 되는 트리.

- **신장 트리 (Spanning Tree)** : 무향 그래프에서 **n개의 정점과 n-1개의 간선**으로 이루어진 트리
- **최소 신장 트리 (Minimum Spanning Tree, MST)** : 무향 가중치 그래프에서 **간선들의 가중치 합이 최소**인 신장 트리

---

## Prim 알고리즘

정점을 하나씩 선택하면서 MST를 확장해 나가는 알고리즘.

### 동작 과정

1. 임의의 정점 하나를 시작 정점으로 선택한다.
2. 현재 트리에 포함된 정점과 포함되지 않은 정점 사이의 간선 중 **가장 가중치가 작은 간선**을 선택한다.
3. 해당 간선으로 연결된 정점을 트리에 추가한다.
4. 모든 정점이 트리에 포함될 때까지 2\~3 과정을 반복한다.

---

### 의사코드 (Pseudo-code)

```pseudo
// G: 그래프, r: 시작 정점, minEdge[]: 각 정점 기준으로 트 정점과의 최소 간선 비용
MST-PRIM(G, r)
    result = 0, cnt = 0 // result: MST 비용, cnt: 처리한 정점 수
    visited[] = false // visited: MST에 포함된 정점 여부


    FOR u in G.V
    minEdge[u] = ∞
    END FOR


    minEdge[r] = 0 // 시작 정점 r의 최소 비용을 0으로 초기화


    WHILE true
        u = Extract-MIN() // 방문하지 않은 정점 중 최소 간선 비용의 정점 선택
        visited[u] = true // 방문 처리
        result = result + minEdge[u]


        IF ++cnt == N THEN break // 모든 정점이 다 연결되면 종료


            FOR v in G.Adj[u] // u의 인접 정점들 확인
            IF visited[v] == false AND w(u, v) < minEdge[v] THEN
                minEdge[v] = w(u, v)
            END IF
        END FOR
    END WHILE


    RETURN result
END MST-PRIM
```

```pseudo
MST-PRIM(G, start)
    FOR 각 정점 v in G.V
        key[v] = ∞
        parent[v] = NIL
    END FOR

    key[start] = 0
    Q = 모든 정점 집합 (우선순위 큐)

    WHILE Q ≠ ∅
        u = Extract-Min(Q)   // key 값이 가장 작은 정점
        FOR 각 (u, v) ∈ G.E
            IF v ∈ Q AND w(u, v) < key[v]
                parent[v] = u
                key[v] = w(u, v)
                Q.decreaseKey(v, key[v])
            END IF
        END FOR
    END WHILE
END MST-PRIM
```

---

### 시간 복잡도

- 인접 행렬 + 배열: **O(V²)**
- 인접 리스트 + PriorityQueue(힙): **O(E log V)**

---

## 자바 구현

### 배열 기반

```java
import java.util.*;

public class PrimArray {
    static final int INF = Integer.MAX_VALUE;

public static int prim(int[][] graph, int V, int start) {
    boolean[] visited = new boolean[V];
    int[] minEdge = new int[V];
    Arrays.fill(minEdge, INF);


    minEdge[start] = 0;
    int result = 0, cnt = 0;


    while (true) {
        int u = -1, min = INF;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && minEdge[i] < min) {
                min = minEdge[i];
                u = i;
            }
        }
    }

        if (u == -1) break; // 더 이상 선택할 정점 없음

        visited[u] = true;
        result += min;

        if (++cnt == V) break; // 모든 정점 선택 완료

        for (int v = 0; v < V; v++) {
            if (!visited[v] && graph[u][v] != 0 && graph[u][v] < minEdge[v]) {
            minEdge[v] = graph[u][v];
            }
        }
    }
    return result;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int E = sc.nextInt();
    int[][] graph = new int[V][V];


    for (int i = 0; i < E; i++) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        int w = sc.nextInt();
        graph[u][v] = w;
        graph[v][u] = w;
    }


    int mstWeight = prim(graph, V, 0); // 0번 정점 시작
    System.out.println("MST 가중치 합: " + mstWeight);
}
```

```java
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class PrimMST {
    static List<List<Node>> graph;

    public static int prim(int V, int start) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int mstWeight = 0;
        int cnt = 0;

        while (!pq.isEmpty() && cnt < V) {
            Node cur = pq.poll();

            if (visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            mstWeight += cur.weight;
            cnt++;

            for (Node next : graph.get(cur.vertex)) {
                if (!visited[next.vertex]) {
                    pq.offer(new Node(next.vertex, next.weight));
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w)); // 무향 그래프
        }

        int mstWeight = prim(V, 1); // 1번 정점에서 시작
        System.out.println("MST 가중치 합: " + mstWeight);
    }
}
```

---

### 입력 형식

```
정점 개수 V, 간선 개수 E
u v w
u v w
...
```

### 예시 입력

```
4 5
1 2 1
1 3 3
2 3 2
2 4 4
3 4 5
```

### 출력

```
MST 가중치 합: 7
```
