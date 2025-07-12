T = int(input())
for t in range(1, T + 1):
    N, K = map(int, input().split())
    V, C = [0], [0]  # 인덱스 맞추기용 (0번 인덱스 안씀)
    for _ in range(N):
        a, b = map(int, input().split())
        V.append(a)
        C.append(b)

    # dp[물건 번호][현재 무게] = 최대 가치
    dp = [[0]*(K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):  # 물건 번호
        for j in range(0, K + 1):  # 현재 무게
            if j < V[i]:
                dp[i][j] = dp[i-1][j]  # 지금 물건 못 넣음
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - V[i]] + C[i])  # 넣거나 안 넣거나 최대

    print(f'#{t} {dp[N][K]}')