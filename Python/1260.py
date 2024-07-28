result = ""
visit = []
graph = []


def dfs(V):
    global result
    result += str(V) + " "
    visit[V] = 1  # 방문 표시

    for node in graph[V]:
        if visit[node] == 0:  # 해당 정점을 아직 방문하지 않았으면
            dfs(node)


queue = []


def bfs(V):
    global result
    queue.append(V)
    visit[V] = 1

    while len(queue) != 0:
        vertex = queue.pop(0)
        result += str(vertex) + " "
        for node in graph[vertex]:
            if visit[node] == 0:
                queue.append(node)
                visit[node] = 1


if __name__ == "__main__":
    N, M, V = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    visit = [0 for _ in range(N + 1)]

    for _ in range(M):
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)

    for i in range(len(graph)):
        graph[i] = sorted(graph[i])

    dfs(V)
    result += "\n"
    visit = [0 for _ in range(N + 1)]
    bfs(V)
    
    print(result)
