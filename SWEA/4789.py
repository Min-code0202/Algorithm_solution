T = int(input())
for t in range(1, T + 1):
    st = input()

    clap = 0
    ans = 0

    for i in range(len(st)):
        if st[i] != "0":
            if clap >= i:
                clap += int(st[i])
            else:
                ans += i - clap
                clap = i + int(st[i])

    print(f'#{t} {ans}')