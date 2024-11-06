K = int(input())
arr = [list(map(int, input().split())) for _ in range(6)]

max_w = max_h = 0
w_idx = h_idx = 0
sub_w = sub_h = 0

for i in range(6):
    if arr[i][0] == 1 or arr[i][0] == 2:
        if max_w < arr[i][1]:
            max_w = arr[i][1]
            w_idx = i
    else:
        if max_h < arr[i][1]:
            max_h = arr[i][1]
            h_idx = i

sub_w = abs(arr[(h_idx + 1) % 6][1] - arr[(h_idx - 1) % 6][1])
sub_h = abs(arr[(w_idx + 1) % 6][1] - arr[(w_idx - 1) % 6][1])

area = max_w * max_h - sub_w * sub_h
print(area * K)