T = int(input())

def dfs(n):
    global ans
    if n == chance:
        ans = max(ans, int("".join(map(str, lst))))
        return
    for i in range(len(lst) - 1):
        for j in range(i + 1, len(lst)):
            lst[i], lst[j] = lst[j], lst[i]

            check = int("".join(map(str, lst)))
            if (n, check) not in visit:
                dfs(n + 1)
                visit.append((n, check))

            lst[i], lst[j] = lst[j], lst[i]


for _ in range(1, T + 1):
    num, chance = map(str, input().split())
    chance = int(chance)
    lst, visit = [], []
    for n in num:
        lst.append(n)

    ans = 0
    dfs(0)

    print(f"#{_} {ans}")
