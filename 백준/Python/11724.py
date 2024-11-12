from collections import deque

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for i in range(1, M + 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
   
   
def bfs(si):
    q = deque()
    q.append(si)
    v[si] = 1
    
    while q:
        ci = q.popleft()
        for node in graph[ci]:
            if v[node] == 0:
                v[node] = 1
                q.append(node)
    
v = [0] * (N + 1)
cnt = 0
for i in range(1, N + 1):
    if v[i] == 0:
        bfs(i)
        cnt += 1
        
print(cnt)