## DFS

> 깊이 우선 탐색은 탐색 시작 정점에서 한 방향으로 갈 수 있는 끝까지 탐색한 뒤,
> 다시 돌아와 다른 방향으로 탐색을 이어가는 방식이다.

### DFS 알고리즘 - 재귀 버전

1. 시작 정점을 방문 처리한다.
2. 해당 정점과 인접한 정점 중 **방문하지 않은 정점**을 재귀적으로 방문한다.

### DFS 구현 - 인접 행렬

```java
import java.util.*;

public class DFSMatrix {
    static int N = 6; // 정점 개수
    static int[][] graph = {
        // 0은 안 씀 (1번 정점부터 시작)
        {0,0,0,0,0,0,0},
        {0,0,1,1,0,0,0},
        {0,1,0,0,1,1,0},
        {0,1,0,0,0,1,0},
        {0,0,1,0,0,0,1},
        {0,0,1,1,0,0,1},
        {0,0,0,0,1,1,0}
    };
    static boolean[] visited = new boolean[N+1];

    public static void dfs(int now) {
        visited[now] = true;
        System.out.print(now + " ");

        for(int i=1; i<=N; i++) {
            if(graph[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        dfs(1); // 1번 정점부터 탐색
    }
}
```

### DFS 구현 - 인접 리스트

```java
import java.util.*;

public class DFSList {
    static int N = 6; // 정점 개수
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[N+1];

    public static void dfs(int now) {
        visited[now] = true;
        System.out.print(now + " ");

        for(int next : graph.get(now)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        // 무방향 그래프 예시
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1); graph.get(2).add(4); graph.get(2).add(5);
        graph.get(3).add(1); graph.get(3).add(5);
        graph.get(4).add(2); graph.get(4).add(6);
        graph.get(5).add(2); graph.get(5).add(3); graph.get(5).add(6);
        graph.get(6).add(4); graph.get(6).add(5);

        dfs(1); // 1번 정점부터 탐색
    }
}
```
