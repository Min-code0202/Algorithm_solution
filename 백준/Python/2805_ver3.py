N, M = map(int, input().split())
height = list(map(int, input().split()))
low, high = 1, max(height)

while low <= high:
    mid = (low + high)//2

    cnt = 0
    for i in height:
        if i > mid:
            cnt += i - mid

    if cnt >= M:
        low = mid + 1
    else:
        high = mid - 1

print(high)