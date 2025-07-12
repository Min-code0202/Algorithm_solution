L = 300
lst = [1] * L

for i in range(2, L):
    lst[i] = lst[i - 1] + i - 1
    
def pos(n):
    si = 1
    while lst[si] <= n:
        si += 1
    si -= 1
    d = n - lst[si]
    return si - d, d + 1

T = int(input())
for t in range(1, T + 1):
    p, q = map(int, input().split()) 

    pi, pj = pos(p)
    qi, qj = pos(q)
    si, sj = pi + qi, pj + qj
    ans = lst[si + sj - 1] + sj - 1 
    
    
    print(f'#{t} {ans}')