H, W = map(int, input().split())
N = int(input())
sticker = [list(map(int, input().split())) for _ in range(N)]


def attach(r1, c1, r2, c2):
    if ((r1 + r2) <= H and max(c1, c2) <= W) or ((c1 + c2) <= W) and max(r1, r2) <= H:
        return True
    if ((r1 + c2) <= H and max(c1, r2) <= W) or ((c1 + r2) <= W) and max(r1, c2) <= H:
        return True
    
    return False


max_area = 0
for i in range(N):
    for j in range(i + 1, N):
        r1, c1 = sticker[i]
        r2, c2 = sticker[j]
        # 둘다 회전 x
        if attach(r1, c1, r2, c2):
            max_area = max(max_area, r1* c1 + r2 * c2)
        # 둘다 회전 
        if attach(c1, r1, c2, r2):
            max_area = max(max_area, r1* c1 + r2 * c2)
        # 첫번째만 회전
        if attach(c1, r1, r2, c2):
            max_area = max(max_area, r1* c1 + r2 * c2)
        # 두번째만 회전
        if attach(r1, c1, c2, r2):
            max_area = max(max_area, r1* c1 + r2 * c2)

print(max_area)