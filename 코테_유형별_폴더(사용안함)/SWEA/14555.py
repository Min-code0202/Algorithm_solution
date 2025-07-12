T = int(input())
for t in range(1, T + 1):
    read = list(input())
    cnt = 0
    for i in range(len(read)):
        if read[i] == '(':
            if read[i + 1] == ')' or read[i + 1] == '|':
                read[i] = read[i + 1] = '_'
                cnt += 1
        if read[i] == ')':
            if read[i - 1] == '|':
                read[i] = read[i - 1] = '_'
                cnt += 1


    print(f'#{t} {cnt}')