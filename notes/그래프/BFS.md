## BFS

> 너비 우선 탐색은 탐색 시작점의 인접한 정점들을 먼저 모두 차례로 방문한 후,
> 방문했던 정점을 시작점으로 하여 다시 인접한 정점들을 차례로 방문하는 방식

### BFS 알고리즘

1. 시작 정점을 큐(Queue)에 넣고 방문 처리한다.
2. 큐가 빌 때까지 다음 과정을 반복한다.
   - 큐에서 정점을 하나 꺼낸다.
   - 해당 정점에 인접한 모든 정점을 확인한다.
   - 아직 방문하지 않은 정점이라면, 방문처리 후 큐에 넣는다.

### 예시

- 그래프

  [그래프](../img/bfs_graph.png)

- 트리

  [트리](../img/bfs_tree.png)

### BFS 구현 - 인접 행렬

````java
```java
import java.util.*;

public class BFSMatrix {
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

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for(int i=1; i<=N; i++) {
                if(graph[now][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bfs(1); // 1번 정점부터 탐색
    }
}
````

### BFS 구현 - 인접 리스트

```java
import java.util.*;

public class BFSList {
    static int N = 6; // 정점 개수
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[N+1];

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
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

        bfs(1); // 1번 정점부터 탐색
    }
}
```
