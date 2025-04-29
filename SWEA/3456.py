T = int(input())
for t in range(1, T + 1):
    n = sorted(list(map(int, input().split())))
    cnt = [0]*(n[-1] + 1)
    for i in n:
        cnt[i] += 1

    ans = cnt.index(1) if max(cnt) == 2 else cnt.index(3)
    print(f'#{t} {ans}')