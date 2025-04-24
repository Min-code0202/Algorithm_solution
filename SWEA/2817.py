T = int(input())

def dfs(n, sm):
    global ans
    if n == N:
        if sm == K:
            ans += 1
        return
    
    dfs(n + 1, sm + A[n])
    dfs(n + 1, sm)

for t in range(1, T + 1):
    N, K = map(int, input().split())
    A = list(map(int, input().split()))

    ans = 0
    dfs(0, 0)

    print(f'#{t} {ans}')