# 최소 신장 트리 (Minimum Spanning Tree, MST)

모든 정점을 연결하는 간선들의 **가중치 합이 최소**가 되는 트리.

- **신장 트리 (Spanning Tree)** : 무향 그래프에서 **n개의 정점과 n-1개의 간선**으로 이루어진 트리
- **최소 신장 트리 (Minimum Spanning Tree, MST)** : 무향 가중치 그래프에서 **간선들의 가중치 합이 최소**인 신장 트리

## Kruskal 알고리즘

간선을 하나씩 선택해서 MST를 찾는 알고리즘.

### 동작 과정

1. 그래프의 **모든 간선을 가중치 기준으로 오름차순 정렬**한다.
2. 사이클을 형성하지 않는 간선을 하나씩 선택하여 MST에 포함한다.
3. 선택된 간선의 수가 **(정점 개수 - 1)** 이 될 때까지 반복한다.

### 의사코드 (Pseudo-code)

```pseudo
MST-KRUSKAL(G)
    cnt = 0, weight = 0
    FOR vertex v in G.V
        Make-Set(v)
    END FOR

    Sort(G.E) // 간선을 가중치 기준 오름차순 정렬

    FOR 간선 (u, v, w) ∈ G.E
        IF Find-Set(u) ≠ Find-Set(v)
            Union(u, v)
            cnt = cnt + 1
            weight = weight + w
            IF cnt == n - 1
                break
        END IF
    END FOR
END MST-KRUSKAL
```

### 시간 복잡도

- 간선 정렬: **O(E log E)**
- Union-Find 연산: **O(E α(V))** (α: 아커만 함수의 역함수, 거의 상수)
- 전체: **O(E log E)**

---

## 자바 구현 (Union-Find 활용)

```java
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.w - other.w;
        // 아래처럼도 가능
        // 오버플로우 방지
        // 양수 - 음수 : 오버플로우, 음수 - 양수 : 언더플로우
        // return Integer.compare(this.w, other.w);
    }
}

public class KruskalMST {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        // 1. 간선 정렬
        Collections.sort(edges);

        // 2. Union-Find 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        int cnt = 0;

        // 3. Kruskal 알고리즘 실행
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                mstWeight += e.w;
                cnt++;
                if (cnt == V - 1) break;
            }
            // 아래 코드가 find를 두번 호출하지 않아 더 좋은 코드임
            // 하지만 union의 반환값을 boolean으로 바꿔야함
            // if (union(e.u, e.v)) {
            //     mstWeight += e.w;
            //     cnt++;
            //     if (cnt == V - 1) break;
            // }
        }

        System.out.println("MST 가중치 합: " + mstWeight);
    }
}
```

---

이 코드는 입력 형식이 다음과 같다고 가정한다:

```
정점 개수 V, 간선 개수 E
u v w
u v w
...
```

예시 입력:

```
4 5
1 2 1
1 3 3
2 3 2
2 4 4
3 4 5
```

출력:

```
MST 가중치 합: 7
```
