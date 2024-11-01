field = [[0]*5 for _ in range(5)]
for i in range(5):
    field[i] = list(map(int, input().split()))
    
num = []
for i in range(5):
    num.extend(list(map(int, input().split())))
    
bingo = [[0]*5 for _ in range(5)]
cnt = 0
for n in num:
    found = False
    cnt += 1
    for i in range(5):
        for j in range(5):
            if field[i][j] == n:
                bingo[i][j] = 1
                found = True
                break
        if found:
            break 
    
    end = 0
    for i in range(5):
        if sum(bingo[i]) == 5:
            end += 1
     
    for i in range(5):
        if sum(bingo[j][i] for j in range(5)) == 5:
            end += 1 
    
    if sum(bingo[i][i] for i in range(5)) == 5:
        end += 1 

    if sum(bingo[4-i][i] for i in range(5)) == 5:
        end += 1 
        
    if end >= 3:
        print(cnt)
        break 