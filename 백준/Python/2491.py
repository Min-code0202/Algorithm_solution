N = int(input())
arr = list(map(int, input().split()))

max_cnt = 1
cnt = 1
for i in range(1, N):
    if arr[i - 1] <= arr[i]:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
    else:
        cnt = 0

cnt = 1
for i in range(1, N):
    if arr[i - 1] >= arr[i]:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
    else:
        cnt = 0

print(max_cnt)