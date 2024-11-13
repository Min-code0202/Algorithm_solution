for _ in range(10):
    t = int(input())
    ladder = [[0] + list(map(int, input().split())) + [0] for _ in range(100)]

    ci = 99
    for j in range(100):
        if ladder[ci][j] == 2:
            cj = j
            break

    while ci > 0:
        ladder[ci][cj] = 0
        if ladder[ci][cj - 1] == 1:
            cj -= 1
        elif ladder[ci][cj + 1] == 1:
            cj += 1
        else:
            ci -= 1

    print(f"#{t} {cj - 1}")