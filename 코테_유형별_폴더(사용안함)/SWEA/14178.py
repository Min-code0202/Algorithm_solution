T = int(input())

for t in range(1, T + 1):
    N, D = map(int, input().split())
    scope = 2 * D + 1  # 분무기가 커버할 수 있는 범위

    # 최소 분무기 수 계산
    ans = N // scope  # 범위로 나눈 몫
    if N % scope != 0:  # 나누어떨어지지 않으면 한 개 추가
        ans += 1

    print(f'#{t} {ans}')