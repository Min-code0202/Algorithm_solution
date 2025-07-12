if __name__ == "__main__":
    N = int(input())
    room = []
    for i in range(N):
        row = input()
        room.append(row)

    width = 0  # 가로
    length = 0  # 세로

    for r in room:
        cnt = 0
        for i in range(N):
            if r[i] == ".":
                cnt += 1
            if r[i] == "X":
                cnt = 0
            if cnt == 2:
                width += 1
                continue

    for col in range(N):
        cnt = 0
        for i in range(N):
            if room[i][col] == ".":
                cnt += 1
            if room[i][col] == "X":
                cnt = 0
            if cnt == 2:
                length += 1
                continue

    print(f"{width} {length}")
