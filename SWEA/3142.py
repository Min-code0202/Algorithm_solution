T = int(input())
for t in range(1, T + 1):
    n, m = map(int, input().split())

    two = one = 0
    for i in range(m + 1):
        if 2 * i + (m - i) == n:
            two = i
            one = m - i
            break

    print(f'#{t} {one} {two}')