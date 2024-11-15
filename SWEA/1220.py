for t in range(1, 11):
    N = int(input())
    table = [list(map(int, input().split())) for _ in range(N)]
    tlst = [list(x) for x in zip(*table)]

    cnt = 0
    for line in tlst:
        prev = 0
        for l in line:
            if l:
                if l == 2 and prev == 1:
                    cnt +=1
                
                prev = l 

    print(f"#{t} {cnt}")