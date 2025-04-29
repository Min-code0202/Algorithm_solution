T = int(input())
for t in range(1, T + 1):
    read = input()
    win = 0
    for r in read:
        if r == 'o':
            win += 1

    rest = 15 - len(read)
    if win >= 8:
        ans = 'YES'
    else:
        ans = 'YES' if rest + win >= 8 else 'NO'

    print(f'#{t} {ans}')