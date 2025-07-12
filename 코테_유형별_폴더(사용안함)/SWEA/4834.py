T = int(input())
for t in range(1, T + 1):
    N = int(input())
    a = sorted(list(map(int, input())))
    cnt = [0] * (max(a) + 1)
    
    for i in a:
        cnt[i] += 1

    mx = 0
    idx = 0
    for i in range(len(cnt)):
        if mx <= cnt[i]:
            mx = cnt[i]
            idx = i

    print(f'#{t} {idx} {mx}')
