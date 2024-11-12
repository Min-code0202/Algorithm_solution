N = int(input())
dices = [list(map(int, input().split())) for _ in range(N)]
max_sum = 0

def solve(dice, bottom):
    for i in range(6):
        if dice[i] == bottom:
            break
        
    if i == 0:
        return (dice[5], max(dice[1], dice[2], dice[3], dice[4]))
    elif i == 1:
        return (dice[3], max(dice[0], dice[2], dice[4], dice[5]))
    elif i == 2:
        return (dice[4], max(dice[0], dice[1], dice[3], dice[5]))
    elif i == 3:
        return (dice[1], max(dice[0], dice[2], dice[4], dice[5]))
    elif i == 4:
        return (dice[2], max(dice[0], dice[1], dice[3], dice[5]))
    elif i == 5:
        return (dice[0], max(dice[1], dice[2], dice[3], dice[4]))
    

for i in range(1, 7):
    bottom = i
    total = 0
    
    for j in range(N):
        bottom, max_num = solve(dices[j], bottom)
        total += max_num
        
    if max_sum < total:
        max_sum = total
        
print(max_sum)