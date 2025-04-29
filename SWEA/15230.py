T = int(input())
for t in range(1, T + 1):
    read = input()
    ch = ord('a')
    cnt = 0
    while cnt < len(read):
        if ch == ord(read[cnt]):
            cnt += 1
            ch += 1
            continue
        else:
            break

    print(f'#{t} {cnt}')