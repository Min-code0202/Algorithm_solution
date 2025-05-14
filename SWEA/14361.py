T = int(input())
for t in range(1, T + 1):
    N = input()
    ans = 'impossible'
    for i in range(2, 10):
        M = str(int(N) * i)

        if len(M) > len(N):
            continue

        if sorted(N) == sorted(M):
            ans = 'possible'
            break

    print(f'#{t} {ans}')
