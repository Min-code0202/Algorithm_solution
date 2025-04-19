T = int(input())

def solution(ci, N, K):
    cnt = 0

    while True:
        disable = 0
        ni = ci + K

        if ni >= N:
            return cnt

        for i in range(ni, ci, -1):
            if bus[i] == 1:
                ci = i
                cnt += 1
                break
            disable += 1
        if disable == K:
            return 0



for t in range(1, T + 1):
    K, N, M = map(int, input().split())
    bus = [0] * (N + 1)
    recharge = list(map(int, input().split()))
    for i in recharge:
        bus[i] = 1
    
    ci = 0
    cnt = solution(ci, N, K)
    print(f'#{t} {cnt}')