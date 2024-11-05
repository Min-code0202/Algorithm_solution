N = int(input())
switch = [-2] + list(map(int, input().split())) + [2]
n = int(input())
for _ in range(n):
    gender, index = map(int, input().split())
    if gender == 1:
        for i in range(index, N + 1):
            if i % index == 0:
                switch[i] = 0 if switch[i] == 1 else 1
    else:
        si = ei = 0
        for i in range(N - index + 1):
            if switch[index - i] == switch[index + i]:
                si, ei = index - i, index + i
            else:
                break

        for i in range(si, ei + 1):
            switch[i] = 0 if switch[i] == 1 else 1

s, *ans, e = switch
for i in range(0, len(ans), 20):
    if i + 20 < len(ans):
        print(*ans[i : i + 20])
    else:
        print(*ans[i : i + 20], end="")