T = int(input())

def solve(c_num, depth, sm):
    global ans
    if ans <= sm:
        return
    if depth == N:
        ans = min(ans, sm + graph[c_num][0])
        return
    
    for i in range(1, N):
        if not visit[i]:
            visit[i] = 1
            solve(i, depth + 1, sm + graph[c_num][i])
            visit[i] = 0

for t in range(1, T + 1):
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]

    ans = float('inf')
    visit = [0] * N
    visit[0] = 1
    solve(0, 1, 0)
    print(f'#{t} {ans}')