N = int(input())
stu_list = list(map(int, input().split()))

order = [i for i in range(1, N + 1)]

for i in range(N):
    n, t = stu_list[i], order[i]
    for j in range(i, i - n, -1):
        order[j] = order[j - 1]

    order[i - n] = t

print(*order)
