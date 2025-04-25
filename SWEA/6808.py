T = int(input())

def dfs(depth, used, iy_perm):
    global win, lose
    if depth == 9:
        gy_score = 0
        iy_score = 0
        for i in range(9):
            if gy[i] > iy_perm[i]:
                gy_score += gy[i] + iy_perm[i]
            else:
                iy_score += gy[i] + iy_perm[i]
        if gy_score > iy_score:
            win += 1
        elif gy_score < iy_score:
            lose += 1
        return

    for i in range(9):
        if not used[i]:
            used[i] = True
            iy_perm[depth] = iy[i]
            dfs(depth + 1, used, iy_perm)
            used[i] = False  # 백트래킹


for t in range(1, T + 1):
    gy = list(map(int, input().split()))
    all_cards = set(range(1, 19))
    iy = list(all_cards - set(gy))

    win = 0
    lose = 0

    used = [False] * 9
    iy_perm = [0] * 9
    dfs(0, used, iy_perm)

    print(f'#{t} {win} {lose}')
