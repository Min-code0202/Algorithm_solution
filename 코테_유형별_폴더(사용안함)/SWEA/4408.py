T = int(input())
for t in range(1, T + 1):
    N = int(input())
    cnt = [0] * 200
    for _ in range(N):
        s, e = map(int, input().split())
        if s > e:
            s, e = e, s

        for i in range((s - 1) // 2, (e - 1) // 2 + 1):
            cnt[i] += 1

    print(f"#{t} {max(cnt)}")