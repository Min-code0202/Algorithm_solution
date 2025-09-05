## DFS 반환 패턴
> DFS를 `void`로만 쓰다 보니, **리턴값**을 활용해서 결과를 전파하는 경우 코드가 꼬이는 상황이 많다.
> 그리하여 자주 쓰이는 3가지 DFS 패턴을 정리할 것이다.

### 성공 / 실패를 반환하는 DFS (boolean)
어떤 조건을 만족하지 않으면 즉시 탐색을 중단하고, 상위 호출로 false를 전파하는 구조
```java
// 주어진 트리에서 값이 0인 노드가 있으면 false 반환
boolean dfs(int node, List<Integer>[] tree, boolean[] visited){
    if(node == 0) return false;

    visited[node] = true;
    for(int nxt : tree[node]){
        if(!visited[nxt]){
            boolean ok = dfs(nxt , tree, visited);
            if(!ok) return false;
        }
    }
    return true; // 모든 노드가 조건 만족 시 성공
}
```

### 최대값 / 합계를 반환하는 DFS (int)
하위 호출의 결과를 받아서 최대값, 합계 등을 누적하는 구조
```java
// 리프까지의 최대 깊이 계산
boolean dfs(int node, List<Integer>[] tree, boolean[] visited){
    visited[node] = true;
    int maxDepth = 1; // 자기자신 포함

    for(int nxt : tree[node]){
        if(!visited[nxt]){
            int depth = 1 + dfs(nxt, tree, visited);
            maxDepth = Math.max(maxDepth, depth);
        }
    }
    return maxDepth;
}
```

### 객체 / 배열을 반환하는 DFS (복합 결과)
여러 정보를 동시에 반환해야 할 때는 **클래스나 배열**로 결과를 담아 리턴
```java
class Result {
    int sum;
    int count;
    Result(int sum, int count) { this.sum = sum; this.count = count; }
}

// 노드 값의 합계와 개수를 동시에 구하는 DFS
Result dfs(int node, List<List<Integer>> tree, boolean[] visited, int[] values) {
    visited[node] = true;
    int total = values[node];
    int cnt = 1;

    for (int next : tree.get(node)) {
        if (!visited[next]) {
            Result r = dfs(next, tree, visited, values);
            total += r.sum;
            cnt += r.count;
        }
    }
    return new Result(total, cnt);
}
```

## 요약
| 패턴 종류     | 리턴 타입     | 사용 예시               |
| --------- | --------- | ------------------- |
| 성공/실패 전파  | `boolean` | 이분 그래프 판별, 조건 만족 여부 |
| 최대값/합계 계산 | `int`     | 경로 길이, 트리 높이 계산     |
| 복합 결과 반환  | `class`   | 합계 + 개수, 최소값 + 경로 등 |