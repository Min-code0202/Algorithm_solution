T = int(input())

INF = int(1e6)
def solve(si, sj, ei, ej):
    q = []
    v = [[INF] * N  for _ in range(N)]
    q.append((si, sj))
    v[si][sj] = 0

    while q:
        ci, cj = q.pop(0)
        
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] > v[ci][cj] + 1 + max(arr[ni][nj] - arr[ci][cj], 0):
                v[ni][nj] = v[ci][cj] + 1 + max(arr[ni][nj] - arr[ci][cj], 0)
                q.append((ni, nj))

    return v[ei][ej]

for t in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    ans = solve(0, 0, N - 1, N - 1)
    print(f'#{t} {ans}')