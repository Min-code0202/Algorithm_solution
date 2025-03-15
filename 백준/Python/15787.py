N, M = map(int, input().split())
train = list([0]*21 for _ in range(N + 1))
for _ in range(M):
    op_lst = list(map(int, input().split()))
    if len(op_lst) == 3:
        order, i, x = op_lst
    else:
        order, i = op_lst
    if order == 1:
        if train[i][x] == 0:
            train[i][x] = 1
    elif order == 2:
        train[i][x] = 0
    elif order == 3:
        passenger = train[i][:]
        train[i][1] = 0
        for k in range(2, 21):
            train[i][k] = passenger[k - 1]
    elif order == 4:
        passenger = train[i][:]
        train[i][20] = 0
        for k in range(1, 20):
            train[i][k] = passenger[k + 1]

passing = []
for i in range(1, N + 1):
    if i == 1:
        passing.append(train[i])
    else:
        if train[i] in passing:
            continue
        passing.append(train[i])

print(len(passing))