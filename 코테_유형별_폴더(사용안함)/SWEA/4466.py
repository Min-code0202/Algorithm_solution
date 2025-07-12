T = int(input())
for t in range(1, T + 1):
    N, K = map(int, input().split())
    score = sorted(list(map(int, input().split())))
    score.reverse()
    ans = sum(score[:K])
    print(f'#{t} {ans}')