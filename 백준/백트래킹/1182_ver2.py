N, S = map(int, input().split())
num_lst = list(map(int, input().split()))

cnt = 0

def search(idx, total):
    global cnt
    if total == S:
        cnt += 1
    for i in range(idx + 1, N):
        search(i, total + num_lst[i])

for i in range(N):
    search(i, num_lst[i])

print(cnt)
