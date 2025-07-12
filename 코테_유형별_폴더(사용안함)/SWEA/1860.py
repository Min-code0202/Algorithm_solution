T = int(input())
for t in range(1, T + 1):
    N, M, K = map(int, input().split())
    p = list(map(int, input().split()))
    p.sort()

    bread = [0] * (p[-1] + 1)
    for i in range(len(bread)):
        if i % M == 0 and i != 0:
            bread[i] = bread[i - 1] + K
        else:
            bread[i] = bread[i - 1]

        if i == p[0]:
            p.pop(0)
            if bread[i] > 0:
                ans = "Possible"
                bread[i] -= 1
            else:
                ans = "Impossible"
                break

    print(f"#{t} {ans}")