N = int(input())
s, e = map(int, input().split())
M = int(input())
graph = [[] for _ in range(N + 1)]

for i in range(M):
    p, c = map(int, input().split())
    graph[p].append(c)
    graph[c].append(p)


def bfs(s, e):
    q = []
    v = [0] * (N + 1)

    q.append(s)
    v[s] = 1

    while q:
        c = q.pop(0)
        if c == e:
            return v[c] - 1

        for node in graph[c]:
            if v[node] == 0:
                q.append(node)
                v[node] = v[c] + 1

    return -1


ans = bfs(s, e)
print(ans)
