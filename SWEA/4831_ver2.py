T = int(input())

for t in range(1, T + 1):
    K, N, M = map(int, input().split())
    recharge = [0] + list(map(int, input().split())) + [N]
    
    cnt = start = 0
    for i in range(1, M + 2):
        if recharge[i] - recharge[i - 1] > K:
            cnt = 0
            break
        if recharge[i] - start > K:
            start = recharge[i - 1]
            cnt += 1

    print(f'#{t} {cnt}')