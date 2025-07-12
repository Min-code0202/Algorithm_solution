T = int(input())

def solve(depth, sm):
    global ans
    if sm >= ans:
        return
    if depth == N:
        ans = min(ans, sm)
        return

    for i in range(N):
        if v[i] == 0:
            v[i] = 1
            solve(depth + 1, sm + fac[depth][i])
            v[i] = 0

for t in range(1, T + 1):
    N = int(input())
    fac = [list(map(int, input().split())) for _ in range(N)]

    v = [0] * N  # 공장
    ans = float('inf')
    solve(0, 0)

    print(f'#{t} {ans}')
