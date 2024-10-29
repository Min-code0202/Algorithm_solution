N = int(input())
field = [[0]*101 for _ in range(101)]

for i in range(N):
    x, y = map(int, input().split())
    for row in range(y, y + 10):
        for col in range(x, x + 10):
            field[row][col] = 1  
           
total = 0
for i in range(100):
    for j in range(100):
        if field[i][j] == 1:
            if field[i-1][j] == 0:
                total += 1
            if field[i][j-1] == 0:
                total +=1
            if field[i+1][j] == 0:
                total += 1
            if field[i][j+1] == 0:
                total += 1

print(total)