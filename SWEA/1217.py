for _ in range(10):
    t = int(input())
    a, b = map(int, input().split())
    ans = a**b
    print(f'#{t} {ans}')