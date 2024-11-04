line = list(input().split())
king = line[0]
dol = line[1]
N = int(line[2])

king_col = ord(king[0])
king_row = int(king[1])
dol_col = ord(dol[0])
dol_row = int(dol[1])

order = ['R', 'L', 'B', 'T', 'RT', 'LT', 'RB', 'LB']
move_row = [0, 0, -1, 1, 1, 1, -1, -1]
move_col = [1, -1, 0, 0, 1, -1, 1, -1]

c_king_col, c_king_row = king_col, king_row
c_dol_col, c_dol_row = dol_col, dol_row
n_dol_col, n_dol_row = 0, 0

for _ in range(N):
    read = input()
    index = order.index(read)
    n_king_col, n_king_row = c_king_col + move_col[index], c_king_row + move_row[index]
    if ord('A') <= n_king_col <= ord('H') and 1 <= n_king_row <= 8:
        if n_king_col == c_dol_col and n_king_row == c_dol_row:
            n_dol_col = c_dol_col + move_col[index]
            n_dol_row = c_dol_row + move_row[index]
            if ord('A') <= n_dol_col <= ord('H') and 1 <= n_dol_row <= 8:
                c_king_col, c_king_row = n_king_col, n_king_row
                c_dol_col, c_dol_row = n_dol_col, n_dol_row
            else:
                continue
        else:
            c_king_col, c_king_row = n_king_col, n_king_row
    
print(chr(c_king_col), c_king_row, sep="")
print(chr(c_dol_col), c_dol_row, sep="")