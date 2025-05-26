N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]

lst.sort(key=lambda x: (x[1], x[0]))
e = 0
ans = 0
for l in lst:
    if l[0] >= e:
        ans += 1
        e = l[1]
print(ans)