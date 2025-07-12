T = int(input())
for t in range(1, T + 1):
    st = input()
    ans = 0
    for i in range(1, len(st)):
        if st[:i] == st[i:i+i]:
            ans = i
            break
    print(f'#{t} {ans}')
