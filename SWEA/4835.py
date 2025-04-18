T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    v = list(map(int, input().split()))

    prefix = [v[0]]
    for i in range(1, N):
        prefix.append(prefix[i - 1] + v[i])

    sub_prefix = []
    for i in range(N - M + 1):
        if i == 0:
            sub_prefix.append(prefix[i + M - 1])
        else:
            sub_prefix.append(prefix[i + M - 1] - prefix[i - 1])

    ans = max(sub_prefix) - min(sub_prefix)
    print(f'#{t} {ans}')