T = int(input())

def solve(depth, sm):
    global ans
    if depth == N:
        ans = min(ans, sm)
        return
    if sm >= ans:
        return
    
    for i in range(N):
        if v[i] == 0:
            v[i] = 1
            solve(depth + 1, sm + arr[depth][i])
            v[i] = 0


for t in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    ans = float('inf')
    v = [0]*N
    solve(0, 0)

    print(f'#{t} {ans}')