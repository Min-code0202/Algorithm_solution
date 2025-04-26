N = int(input())

cnt = 0
for i in range(1, N + 1):
    for j in range(i, N + 1):
        if i * j <= N:
            cnt += 1
            
print(cnt)

# ver.2
cnt = N
for i in range(2, N):
    n = N//i - (i - 1)
    if n < 1:
        break
    cnt += n
print(cnt)