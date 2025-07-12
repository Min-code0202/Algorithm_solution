T = int(input())

def solve(n):
    if n > N:  # 노드 번호가 범위를 벗어날 경우
        return 0
    if tree[n] != 0:
        return tree[n]
    tree[n] = solve(n*2) + solve(n*2 + 1)
    return tree[n]

for t in range(1, T + 1):
    N, M, L = map(int, input().split())
    tree = [0] * (N + 1)
    for _ in range(M):
        idx, val = map(int, input().split())
        tree[idx] = val

    ans = solve(L)
    print(f'#{t} {ans}')
