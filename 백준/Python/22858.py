N, K = map(int, input().split())
P = [[0] + list(map(int, input().split()))] +[[0]*(N + 1) for _ in range(K)]
D = [0] + list(map(int, input().split()))

if K == 1:
    for i in range(1, N + 1):
        S_card = P[0][i]
        dis_idx = D[i]
        P[1][dis_idx] = S_card
else:
    for r in range(1, K + 1):
        for i in range(1, N + 1):
            S_card = P[r - 1][i]
            dis_idx = D[i]
            P[r][dis_idx] = S_card

ans = ''
for i in range(1, N + 1):
    ans += str(P[K][i]) + ' '

print(ans)