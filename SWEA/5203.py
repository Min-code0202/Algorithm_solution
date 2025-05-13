from collections import Counter

T = int(input())

def solve(a, b):
    def check(cards):
        counter = Counter(cards)

        # 트리플
        for v in counter.values():
            if v >= 3:
                return True

        # 런 (연속된 숫자 3개)
        for i in range(8):  # 0~7까지 체크하면 i, i+1, i+2 가능
            if counter[i] and counter[i+1] and counter[i+2]:
                return True

        return False

    if check(a):
        return 1
    if check(b):
        return 2
    return 0

for t in range(1, T + 1):
    c = list(map(int, input().split()))
    
    A = []
    B = []
    ans = 0
    for i in range(6):
        A.append(c[i*2])
        B.append(c[i*2 + 1])
        if i >= 2:
            ans = solve(A, B)
            if ans != 0:
                break

    print(f'#{t} {ans}')
